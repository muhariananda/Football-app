package com.aria.footballapp.ui.league

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.LeaguesEntity

class LeagueViewModel(private val footballRepository: FootballRepository?) : ViewModel() {

    var data: LiveData<List<LeaguesEntity>>? = null

    fun initLeague() {
        if (data != null) {
            return
        }

        data = footballRepository?.getAllLeague()
    }

    fun getLeague(): LiveData<List<LeaguesEntity>>? {
        return data
    }
}