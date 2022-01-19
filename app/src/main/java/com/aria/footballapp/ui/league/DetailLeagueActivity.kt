package com.aria.footballapp.ui.league

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aria.footballapp.R
import com.aria.footballapp.data.source.local.entity.LeaguesEntity
import com.aria.footballapp.ui.adapter.TabAdapter
import com.aria.footballapp.ui.event.EventLastFragment
import com.aria.footballapp.ui.event.EventNextFragment
import com.aria.footballapp.ui.table.TableFragment
import com.aria.footballapp.ui.team.TeamFragment
import com.aria.footballapp.viewmodel.ViewModelFactory
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_league.*

class DetailLeagueActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailLeagueViewModel

    private lateinit var league: String
    private lateinit var leagueId: String

    companion object {
        const val EXTRA_LEAGUE = "extra_league"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)


        val extra = intent.getParcelableExtra<LeaguesEntity>(EXTRA_LEAGUE)
        if (extra != null) {
            league = extra.strLeague
            leagueId = extra.idLeague
        }

        val factory = ViewModelFactory.instance(this)
        viewModel = ViewModelProvider(this, factory)[DetailLeagueViewModel::class.java]

        viewModel.initLeague(leagueId)
        viewModel.leagues?.observe(this, Observer { leagues ->
            if (leagues != null) {
                populateLeague(leagues)
            }
        })

        getViewPager()
    }

    private fun getViewPager() {
        val adapter = TabAdapter(supportFragmentManager)
        adapter.addFragment(
            DetailInformationFragment.create(leagueId),
            resources.getString(R.string.detail)
        )
        adapter.addFragment(TeamFragment.create(league), resources.getString(R.string.teams))
        adapter.addFragment(
            EventLastFragment.create(leagueId),
            resources.getString(R.string.last_match)
        )
        adapter.addFragment(
            EventNextFragment.create(leagueId),
            resources.getString(R.string.next_match)
        )
        adapter.addFragment(
            TableFragment.getInstance(leagueId),
            resources.getString(R.string.standing)
        )
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)
    }

    private fun populateLeague(league: LeaguesEntity) {
        tv_detail_league.text = league.strLeague
        tv_detail_country.text = league.strCountry

        Picasso.get().load(league.strBadge).fit().into(img_detail_badge)
        Picasso.get().load(league.strFanart2).fit().into(img_banner)
    }
}
