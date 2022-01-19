package com.aria.footballapp.ui.favorite.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.TeamsEntity

class FavoriteTeamViewModel(private val footballRepository: FootballRepository) : ViewModel() {

    fun getFavorite(): LiveData<PagedList<TeamsEntity>> =
        footballRepository.getFavoriteTeam()
}