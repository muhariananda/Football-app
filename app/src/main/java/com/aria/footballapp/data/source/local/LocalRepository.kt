package com.aria.footballapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.data.source.local.room.FootballDao

class LocalRepository constructor(private val footballDao: FootballDao) {

    companion object {
        private var INSTANCE: LocalRepository? = null

        fun getInstance(footballDao: FootballDao): LocalRepository {
            if (INSTANCE == null) {
                INSTANCE = LocalRepository(footballDao)
            }
            return INSTANCE as LocalRepository
        }
    }

    fun getFavoriteTeam(): DataSource.Factory<Int, TeamsEntity> {
        return footballDao.getFavoriteTeam()
    }

    fun getTeam(idTeam: String): LiveData<TeamsEntity> {
        return footballDao.getTeam(idTeam)
    }

    fun insertTeam(teams: TeamsEntity) {
        footballDao.insertTeam(teams)
    }

    fun setFavoriteTeam(teams: TeamsEntity, newState: Boolean) {
        teams.isFavorite = newState
        footballDao.updateTeam(teams)
    }

    fun getFavoriteEvents(): DataSource.Factory<Int, EventsEntity> {
        return footballDao.getFavoriteEvent()
    }

    fun getEvent(idEvent: String): LiveData<EventsEntity> {
        return footballDao.getEvent(idEvent)
    }

    fun insertEvents(events: EventsEntity) {
        footballDao.insertEvent(events)
    }

    fun setFavoriteEvent(events: EventsEntity, newState: Boolean) {
        events.isFavorite = newState
        footballDao.updateEvent(events)
    }
}