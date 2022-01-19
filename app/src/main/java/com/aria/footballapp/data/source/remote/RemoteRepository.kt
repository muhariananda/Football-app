package com.aria.footballapp.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aria.footballapp.BuildConfig
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.data.source.local.entity.LeaguesEntity
import com.aria.footballapp.data.source.local.entity.TableEntity
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.data.source.remote.respon.EventResponse
import com.aria.footballapp.data.source.remote.respon.LeagueResponse
import com.aria.footballapp.data.source.remote.respon.TableResponse
import com.aria.footballapp.data.source.remote.respon.TeamsResponse
import com.aria.footballapp.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteRepository(private val api: ApiService) {

    companion object {
        fun instance(): RemoteRepository {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return RemoteRepository(retrofit.create(ApiService::class.java))
        }
    }


    //League
    fun getDetailLeague(leagueId: String): LiveData<LeaguesEntity> {
        EspressoIdlingResource.increment()
        val leagueResult = MutableLiveData<LeaguesEntity>()
        api.getLeague(leagueId).enqueue(object : Callback<LeagueResponse> {
            override fun onResponse(
                call: Call<LeagueResponse>,
                response: Response<LeagueResponse>
            ) {
                if (response.isSuccessful) {
                    val leagueResponse = response.body()
                    if (leagueResponse?.leagues != null) {
                        leagueResult.value = leagueResponse.leagues[0]
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<LeagueResponse>, t: Throwable) {

            }
        })
        return leagueResult
    }


    //Events
    fun getNextEvent(leagueId: String): LiveData<List<EventsEntity>> {
        EspressoIdlingResource.increment()
        val eventResult = MutableLiveData<List<EventsEntity>>()
        api.getNextEvent(leagueId).enqueue(object : Callback<EventResponse> {
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                if (response.isSuccessful) {
                    val eventResponse = response.body()
                    if (eventResponse?.events != null) {
                        eventResult.value = eventResponse.events
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                Log.d("TAG", "onFailure")
            }
        })

        return eventResult
    }

    fun getLastEvent(leagueId: String): LiveData<List<EventsEntity>> {
        EspressoIdlingResource.increment()
        val eventResult = MutableLiveData<List<EventsEntity>>()
        api.getLastEvent(leagueId).enqueue(object : Callback<EventResponse> {
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                if (response.isSuccessful) {
                    val eventResponse = response.body()
                    if (eventResponse?.events != null) {
                        eventResult.value = eventResponse.events
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {

            }
        })
        return eventResult
    }

    fun getSearchEvent(team: String): LiveData<List<EventsEntity>> {
        EspressoIdlingResource.increment()
        val eventResult = MutableLiveData<List<EventsEntity>>()

        api.getSearchEvent(team).enqueue(object : Callback<EventResponse> {
            override fun onResponse(
                call: Call<EventResponse>,
                response: Response<EventResponse>
            ) {
                if (response.isSuccessful) {
                    eventResult.value = response.body()?.event
                    EspressoIdlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {

            }
        })
        return eventResult
    }

    fun getDetailEvent(eventId: String): LiveData<ApiResponse<EventsEntity>> {
        EspressoIdlingResource.increment()
        val eventResult = MutableLiveData<ApiResponse<EventsEntity>>()
        api.getDetailEvent(eventId).enqueue(object : Callback<EventResponse> {
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                if (response.isSuccessful) {
                    val eventResponse = response.body()
                    if (eventResponse?.events != null) {
                        eventResult.value = ApiResponse.success(eventResponse.events[0])
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {

            }
        })
        return eventResult
    }

    //Teams
    fun getAllTeams(league: String?): LiveData<List<TeamsEntity>> {
        EspressoIdlingResource.increment()
        val teamResult = MutableLiveData<List<TeamsEntity>>()
        api.getAllTeam(league).enqueue(object : Callback<TeamsResponse> {
            override fun onResponse(call: Call<TeamsResponse>, response: Response<TeamsResponse>) {
                if (response.isSuccessful) {
                    val teamResponse = response.body()
                    if (teamResponse?.teams != null) {
                        teamResult.value = teamResponse.teams
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<TeamsResponse>, t: Throwable) {

            }
        })
        return teamResult
    }

    fun getSearchTeam(team: String): LiveData<List<TeamsEntity>> {
        EspressoIdlingResource.increment()
        val teamResult = MutableLiveData<List<TeamsEntity>>()

        api.getSearchTeam(team).enqueue(object : Callback<TeamsResponse> {
            override fun onResponse(call: Call<TeamsResponse>, response: Response<TeamsResponse>) {
                if (response.isSuccessful) {
                    val teamResponse = response.body()
                    if (teamResponse?.teams != null) {
                        teamResult.value = teamResponse.teams
                    }
                }
            }

            override fun onFailure(call: Call<TeamsResponse>, t: Throwable) {

            }
        })
        return teamResult
    }

    fun getDetailTeam(teamId: String): LiveData<ApiResponse<TeamsEntity>> {
        EspressoIdlingResource.increment()
        val teamResult = MutableLiveData<ApiResponse<TeamsEntity>>()
        api.getDetailTeam(teamId).enqueue(object : Callback<TeamsResponse> {
            override fun onResponse(call: Call<TeamsResponse>, response: Response<TeamsResponse>) {
                if (response.isSuccessful) {
                    val teamResponse = response.body()
                    if (teamResponse?.teams != null) {
                        teamResult.value = ApiResponse.success(teamResponse.teams[0])
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<TeamsResponse>, t: Throwable) {

            }
        })
        return teamResult
    }

    //Table
    fun getTable(idLeague: String): LiveData<List<TableEntity>> {
        EspressoIdlingResource.increment()
        val tableResult = MutableLiveData<List<TableEntity>>()
        api.getTable(idLeague).enqueue(object : Callback<TableResponse> {
            override fun onResponse(call: Call<TableResponse>, response: Response<TableResponse>) {
                if (response.isSuccessful) {
                    val tableResponse = response.body()
                    if (tableResponse?.table != null) {
                        tableResult.value = tableResponse.table
                    }
                }
            }

            override fun onFailure(call: Call<TableResponse>, t: Throwable) {

            }
        })
        return tableResult
    }
}