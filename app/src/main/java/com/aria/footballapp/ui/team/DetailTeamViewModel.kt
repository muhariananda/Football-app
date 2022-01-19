package com.aria.footballapp.ui.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.vo.Resource

class DetailTeamViewModel(private val footballRepository: FootballRepository) : ViewModel() {

    var data: LiveData<Resource<TeamsEntity>>? = null
    var idTeam = MutableLiveData<String>()

    fun initTeam(teamId: String) {
        if (data != null) {
            return
        }

        data = Transformations.switchMap(idTeam) { footballRepository.getDetailTeam(teamId) }
    }

    fun setFavorite() {
        if (data?.value != null) {
            val team = data?.value?.data
            if (team != null) {
                val newState = !team.isFavorite
                footballRepository.setTeamFavorite(team, newState)
            }
        }
    }
}