package com.aria.footballapp.ui.table

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.TableEntity

class TableViewModel(private val footballRepository: FootballRepository) : ViewModel() {

    var table: LiveData<List<TableEntity>>? = null

    fun initTable(idLeague: String) {
        if (table != null) return
        table = footballRepository.getTable(idLeague)
    }
}