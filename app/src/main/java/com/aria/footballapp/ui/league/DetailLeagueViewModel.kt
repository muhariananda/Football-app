package com.aria.footballapp.ui.league

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.LeaguesEntity

class DetailLeagueViewModel(private val footballRepository: FootballRepository) : ViewModel() {

    var leagues: LiveData<LeaguesEntity>? = null

    fun initLeague(idLeague: String) {
        if (leagues != null) return
        leagues = footballRepository.getDetailLeague(idLeague)
    }
}