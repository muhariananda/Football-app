package com.aria.footballapp.data.source.remote.respon


import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.google.gson.annotations.SerializedName


data class EventResponse(

    @field:SerializedName("event")
    val event: List<EventsEntity>? = null,

    @field:SerializedName("events")
    val events: List<EventsEntity>? = null
)