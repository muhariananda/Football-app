package com.aria.footballapp.ui.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.TeamsEntity

class TeamsViewModel(private val footballRepository: FootballRepository) : ViewModel() {

    var teams: LiveData<List<TeamsEntity>>? = null

    fun initTeam(league: String?) {
        if (teams != null) return
        teams = footballRepository.getAllTeams(league)
    }
}