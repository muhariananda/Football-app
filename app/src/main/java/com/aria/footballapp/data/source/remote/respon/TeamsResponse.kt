package com.aria.footballapp.data.source.remote.respon


import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.google.gson.annotations.SerializedName

data class TeamsResponse(

    @field:SerializedName("teams")
    val teams: List<TeamsEntity>? = null
)