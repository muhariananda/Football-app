package com.aria.footballapp.ui.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.TeamsEntity

class TeamSearchViewModel(private val footballRepository: FootballRepository): ViewModel() {

    var teams: LiveData<List<TeamsEntity>>? = null

    fun initSearch(team: String) {
        teams = footballRepository.getSearchTeam(team)
    }
}