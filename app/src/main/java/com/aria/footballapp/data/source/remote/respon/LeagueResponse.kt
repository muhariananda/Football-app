package com.aria.footballapp.data.source.remote.respon


import com.aria.footballapp.data.source.local.entity.LeaguesEntity
import com.google.gson.annotations.SerializedName

data class LeagueResponse(

    @field:SerializedName("leagues")
    val leagues: List<LeaguesEntity>
)