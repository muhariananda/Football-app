package com.aria.footballapp.ui.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.EventsEntity

class EventSearchViewModel(private val footballRepository: FootballRepository?) : ViewModel() {

    var data: LiveData<List<EventsEntity>>? = null

    fun init(query: String) {
        data = footballRepository?.getSearchEvent(query)
    }
}