package com.aria.footballapp.ui.event

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aria.footballapp.R
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.viewmodel.ViewModelFactory
import com.aria.footballapp.vo.Resource
import com.aria.footballapp.vo.Status
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_event.*
import kotlinx.android.synthetic.main.container_cv_detail_event.*
import java.text.SimpleDateFormat
import java.util.*

class DetailEventActivity : AppCompatActivity() {

    private var menu: Menu? = null
    internal lateinit var viewModel: DetailEventViewModel

    private lateinit var eventId: String
    private lateinit var idHome: String
    private lateinit var idAway: String

    companion object {
        const val EXTRA_EVENT = "extra_event"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_event)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.elevation = 0F
        showLoading(true)

        val extra = intent.getParcelableExtra<EventsEntity>(EXTRA_EVENT)
        if (extra != null) {
            eventId = extra.idEvent
            idHome = extra.idHomeTeam
            idAway = extra.idAwayTeam
        }

        val factory = ViewModelFactory.instance(this)
        viewModel = ViewModelProvider(this, factory)[DetailEventViewModel::class.java]

        viewModel.idEvent.value = eventId
        viewModel.initEvent(eventId)
        viewModel.data?.observe(this, Observer { events: Resource<EventsEntity> ->
            when (events.status) {
                Status.LOADING -> showLoading(true)
                Status.SUCCESS -> {
                    showLoading(false)
                    events.data?.let { populateEvents(it) }
                }
                Status.ERROR -> {
                    showLoading(false)
                    showError()
                }
            }
        })

        viewModel.initTeam(idHome, idAway)
        viewModel.teamHome?.observe(this, Observer { teamHome: Resource<TeamsEntity> ->
            if (teamHome.status == Status.SUCCESS) {
                Picasso.get().load(teamHome.data?.strTeamBadge).fit().into(img_team_home)
            }
        })

        viewModel.teamAway?.observe(this, Observer { teamAway: Resource<TeamsEntity> ->
            if (teamAway.status == Status.SUCCESS) {
                Picasso.get().load(teamAway.data?.strTeamBadge).fit().into(img_team_away)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.data?.observe(this, Observer { events ->
            if (events != null) {
                when (events.status) {
                    Status.LOADING -> showLoading(true)
                    Status.SUCCESS -> if (events.data != null) {
                        showLoading(false)
                        val state = events.data.isFavorite
                        setFavorite(state)
                    }
                    Status.ERROR -> {
                        showLoading(false)
                        showError()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setFavorite()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    @SuppressLint("SimpleDateFormat")
    private fun populateEvents(event: EventsEntity) {
        tv_team_home.text = event.strHomeTeam
        tv_team_away.text = event.strAwayTeam
        tv_score_home.text = event.intHomeScore
        tv_score_away.text = event.intAwayScore
        tv_goals_home.text = event.strHomeGoalDetails
        tv_goal_away.text = event.strAwayGoalDetails
        tv_yellow_home.text = event.strHomeYellowCards
        tv_yellow_away.text = event.strAwayYellowCards
        tv_red_home.text = event.strHomeRedCards
        tv_red_away.text = event.strAwayRedCards

        val dateConvert = toGMTFormat(event.dateEvent, event.strTime)
        val formatDate = SimpleDateFormat("E, dd/MM")
        val date = formatDate.format(dateConvert)

        tv_event_date.text = date

        if (event.intHomeScore == null && event.intAwayScore == null) {
            Toast.makeText(this, "The match hasn't started yet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setFavorite(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_border)
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
            container_event.visibility = View.INVISIBLE
        } else {
            progress_bar.visibility = View.GONE
            container_event.visibility = View.VISIBLE
        }
    }

    private fun showError() {
        Toast.makeText(this, resources.getString(R.string.error), Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SimpleDateFormat")
    private fun toGMTFormat(date: String?, time: String?): Date {
        val convert = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        convert.timeZone = TimeZone.getTimeZone("UTC")
        val dateTime = "$date $time"
        return convert.parse(dateTime)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
