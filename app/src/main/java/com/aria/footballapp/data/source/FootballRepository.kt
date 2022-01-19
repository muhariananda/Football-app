package com.aria.footballapp.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aria.footballapp.data.source.local.LocalRepository
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.data.source.local.entity.LeaguesEntity
import com.aria.footballapp.data.source.local.entity.TableEntity
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.data.source.remote.ApiResponse
import com.aria.footballapp.data.source.remote.RemoteRepository
import com.aria.footballapp.utils.AppExecutors
import com.aria.footballapp.utils.DataDummy
import com.aria.footballapp.vo.Resource

class FootballRepository(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository,
    private val appExecutors: AppExecutors
) : FootballDataSource {

    companion object {
        @Volatile
        private var instance: FootballRepository? = null

        fun getInstance(
            localRepository: LocalRepository,
            remoteRepository: RemoteRepository,
            appExecutors: AppExecutors
        ): FootballRepository =
            instance ?: synchronized(this) {
                instance ?: FootballRepository(localRepository, remoteRepository, appExecutors)
            }
    }


    override fun getAllLeague(): LiveData<List<LeaguesEntity>> {
        val data = MutableLiveData<List<LeaguesEntity>>()
        data.value = DataDummy.generateAllLeague()

        return data
    }

    override fun getDetailLeague(leagueId: String): LiveData<LeaguesEntity> {
        return remoteRepository.getDetailLeague(leagueId)
    }

    override fun getNextEvent(leagueId: String): LiveData<List<EventsEntity>> {
        return remoteRepository.getNextEvent(leagueId)
    }

    override fun getLastEvent(leagueId: String): LiveData<List<EventsEntity>> {
        return remoteRepository.getLastEvent(leagueId)
    }

    override fun getSearchEvent(team: String): LiveData<List<EventsEntity>> {
        return remoteRepository.getSearchEvent(team)
    }

    override fun getAllTeams(league: String?): LiveData<List<TeamsEntity>> {
        return remoteRepository.getAllTeams(league)
    }

    override fun getSearchTeam(team: String): LiveData<List<TeamsEntity>> {
        return remoteRepository.getSearchTeam(team)
    }

    override fun getTable(idLeague: String): LiveData<List<TableEntity>> {
        return remoteRepository.getTable(idLeague)
    }

    override fun getFavoriteEvents(): LiveData<PagedList<EventsEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()

        return LivePagedListBuilder(localRepository.getFavoriteEvents(), config).build()
    }

    override fun getFavoriteTeam(): LiveData<PagedList<TeamsEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()

        return LivePagedListBuilder(localRepository.getFavoriteTeam(), config).build()
    }

    override fun getDetailEvent(eventId: String): LiveData<Resource<EventsEntity>> {
        return object : NetworkBoundResource<EventsEntity, EventsEntity>(appExecutors) {

            override fun loadFromDB(): LiveData<EventsEntity> {
                return localRepository.getEvent(eventId)
            }

            override fun shouldFetch(data: EventsEntity?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<EventsEntity>> {
                return remoteRepository.getDetailEvent(eventId)
            }

            override fun saveCallResult(data: EventsEntity) {
                localRepository.insertEvents(data)
            }
        }.asLiveData()
    }

    override fun getDetailTeam(teamId: String): LiveData<Resource<TeamsEntity>> {
        return object : NetworkBoundResource<TeamsEntity, TeamsEntity>(appExecutors) {

            override fun loadFromDB(): LiveData<TeamsEntity> {
                return localRepository.getTeam(teamId)
            }

            override fun shouldFetch(data: TeamsEntity?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<TeamsEntity>> {
                return remoteRepository.getDetailTeam(teamId)
            }

            override fun saveCallResult(data: TeamsEntity) {
                localRepository.insertTeam(data)
            }
        }.asLiveData()
    }

    override fun setEventFavorite(events: EventsEntity, state: Boolean) {
        val runnable = Runnable { localRepository.setFavoriteEvent(events, state) }
        appExecutors.diskIO().execute(runnable)
    }

    override fun setTeamFavorite(teams: TeamsEntity, state: Boolean) {
        val runnable = Runnable { localRepository.setFavoriteTeam(teams, state) }
        appExecutors.diskIO().execute(runnable)
    }
}