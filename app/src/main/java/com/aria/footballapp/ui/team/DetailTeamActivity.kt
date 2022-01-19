package com.aria.footballapp.ui.team

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
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.viewmodel.ViewModelFactory
import com.aria.footballapp.vo.Resource
import com.aria.footballapp.vo.Status
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_team.*

class DetailTeamActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailTeamViewModel
    private lateinit var teamId: String
    private var menu: Menu? = null

    companion object {
        const val EXTRA_TEAM = "extra_team"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.elevation = 0F

        showLoading(true)

        val extra = intent.getParcelableExtra<TeamsEntity>(EXTRA_TEAM)
        if (extra != null) {
            teamId = extra.idTeam
        }

        val factory = ViewModelFactory.instance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTeamViewModel::class.java]

        viewModel.idTeam.value = teamId
        viewModel.initTeam(teamId)
        viewModel.data?.observe(this, Observer { teams: Resource<TeamsEntity> ->
            when (teams.status) {
                Status.LOADING -> showLoading(true)
                Status.SUCCESS -> {
                    showLoading(false)
                    teams.data?.let { populateTeams(it) }
                }
                Status.ERROR -> {
                    showLoading(false)
                    showError()
                }
            }
        })
    }

    private fun populateTeams(team: TeamsEntity) {
        tv_team_name.text = team.strTeam
        tv_team_location.text = team.strStadiumLocation
        tv_team_description.text = team.strDescriptionEN

        Picasso.get().load(team.strTeamBadge).fit().into(img_team_badge)
        Picasso.get().load(team.strStadiumThumb).fit().into(img_team_banner)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.data?.observe(this, Observer { teams ->
            if (teams != null) {
                when (teams.status) {
                    Status.LOADING -> showLoading(true)
                    Status.SUCCESS -> if (teams.data != null) {
                        showLoading(false)
                        val newState = teams.data.isFavorite
                        setFavorite(newState)
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
        } else {
            progress_bar.visibility = View.GONE
        }
    }

    private fun showError() {
        Toast.makeText(this, resources.getString(R.string.error), Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
