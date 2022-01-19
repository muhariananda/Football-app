package com.aria.footballapp.data.source.local.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.data.source.local.entity.TeamsEntity

@Dao
interface FootballDao {

    //Team
    @Query("SELECT * FROM team_table")
    @WorkerThread
    fun getAllTeams(): LiveData<List<TeamsEntity>>

    @Query("SELECT * FROM TEAM_TABLE WHERE isFavorite = 1")
    fun getFavoriteTeam(): DataSource.Factory<Int, TeamsEntity>

    @Transaction
    @Query("SELECT * FROM team_table WHERE idTeam =:idTeam")
    fun getTeam(idTeam: String): LiveData<TeamsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeam(teams: TeamsEntity): Long

    @Update
    fun updateTeam(teams: TeamsEntity): Int

    @Query("UPDATE team_table SET strTeam =:strTeam WHERE idTeam =:idTeam")
    fun updateTeamById(strTeam: String, idTeam: String)

    //Event
    @Query("SELECT * FROM event_table")
    @WorkerThread
    fun getAllEvents(): LiveData<List<EventsEntity>>

    @Query("SELECT * FROM event_table WHERE isFavorite = 1")
    @WorkerThread
    fun getFavoriteEvent(): DataSource.Factory<Int, EventsEntity>

    @Transaction
    @Query("SELECT * FROM event_table WHERE idEvent =:idEvent")
    fun getEvent(idEvent: String): LiveData<EventsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(events: EventsEntity): Long

    @Update
    fun updateEvent(events: EventsEntity): Int

    @Query("UPDATE event_table SET strEvent =:strEvent WHERE idEvent =:idEvent")
    fun updateEventById(strEvent: String, idEvent: String): Int
}