package com.aria.footballapp.ui.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.vo.Resource

class DetailEventViewModel(private val footballRepository: FootballRepository) : ViewModel() {

    var data: LiveData<Resource<EventsEntity>>? = null
    var teamHome: LiveData<Resource<TeamsEntity>>? = null
    var teamAway: LiveData<Resource<TeamsEntity>>? = null

    var idEvent = MutableLiveData<String>()

    fun initEvent(eventId: String) {
        if (data != null) {
            return
        }

        data = Transformations.switchMap(idEvent) { footballRepository.getDetailEvent(eventId) }
    }

    fun initTeam(idTeamHome: String, idTeamAway: String) {
        if (teamHome != null && teamAway != null) {
            return
        }

        teamHome =
            Transformations.switchMap(idEvent) { footballRepository.getDetailTeam(idTeamHome) }
        teamAway =
            Transformations.switchMap(idEvent) { footballRepository.getDetailTeam(idTeamAway) }
    }

    fun setFavorite() {
        if (data?.value != null) {
            val events = data?.value?.data
            if (events != null) {
                val newState = !events.isFavorite
                footballRepository.setEventFavorite(events, newState)
            }
        }
    }
}