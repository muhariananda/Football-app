package com.aria.footballapp.ui.favorite.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.EventsEntity

class FavoriteEventViewModel(private val footballRepository: FootballRepository) : ViewModel() {

    fun getFavorite(): LiveData<PagedList<EventsEntity>> =
        footballRepository.getFavoriteEvents()
}