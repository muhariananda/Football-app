package com.aria.footballapp.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.data.source.local.entity.LeaguesEntity
import com.aria.footballapp.data.source.local.entity.TableEntity
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.vo.Resource

interface FootballDataSource {

    fun getAllLeague(): LiveData<List<LeaguesEntity>>

    fun getDetailLeague(leagueId: String): LiveData<LeaguesEntity>

    fun getNextEvent(leagueId: String): LiveData<List<EventsEntity>>

    fun getLastEvent(leagueId: String): LiveData<List<EventsEntity>>

    fun getSearchEvent(team: String): LiveData<List<EventsEntity>>

    fun getFavoriteEvents(): LiveData<PagedList<EventsEntity>>

    fun getDetailEvent(eventId: String): LiveData<Resource<EventsEntity>>

    fun getAllTeams(league: String?): LiveData<List<TeamsEntity>>

    fun getSearchTeam(team: String): LiveData<List<TeamsEntity>>

    fun getFavoriteTeam(): LiveData<PagedList<TeamsEntity>>

    fun getDetailTeam(teamId: String): LiveData<Resource<TeamsEntity>>

    fun getTable(idLeague: String): LiveData<List<TableEntity>>

    fun setEventFavorite(events: EventsEntity, state: Boolean)

    fun setTeamFavorite(teams: TeamsEntity, state: Boolean)
}