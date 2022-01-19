package com.aria.footballapp.data.source.remote

import com.aria.footballapp.data.source.remote.respon.EventResponse
import com.aria.footballapp.data.source.remote.respon.LeagueResponse
import com.aria.footballapp.data.source.remote.respon.TableResponse
import com.aria.footballapp.data.source.remote.respon.TeamsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("lookupleague.php")
    fun getLeague(@Query("id") leagueId: String): Call<LeagueResponse>

    @GET("eventsnextleague.php")
    fun getNextEvent(@Query("id") leagueId: String): Call<EventResponse>

    @GET("eventspastleague.php")
    fun getLastEvent(@Query("id") leagueId: String): Call<EventResponse>

    @GET("searchevents.php")
    fun getSearchEvent(@Query("e") e: String): Call<EventResponse>

    @GET("lookupevent.php")
    fun getDetailEvent(@Query("id") eventId: String): Call<EventResponse>

    @GET("search_all_teams.php")
    fun getAllTeam(@Query("l") league: String?): Call<TeamsResponse>

    @GET("searchteams.php")
    fun getSearchTeam(@Query("t") t: String): Call<TeamsResponse>

    @GET("lookupteam.php")
    fun getDetailTeam(@Query("id") teamId: String): Call<TeamsResponse>

    @GET("lookuptable.php")
    fun getTable(@Query("l") l: String): Call<TableResponse>
}