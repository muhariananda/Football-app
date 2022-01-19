package com.aria.footballapp.data.source.local.entity


import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "event_table")
data class EventsEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idEvent")
    @field:SerializedName("idEvent")
    var idEvent: String,

    @ColumnInfo(name = "idHomeTeam")
    @field:SerializedName("idHomeTeam")
    var idHomeTeam: String,

    @ColumnInfo(name = "idAwayTeam")
    @field:SerializedName("idAwayTeam")
    var idAwayTeam: String,

    @field:SerializedName("idLeague")
    var idLeague: String = "",

    @ColumnInfo(name = "strEvent")
    @field:SerializedName("strEvent")
    var strEvent: String? = "",

    @ColumnInfo(name = "strHomeTeam")
    @field:SerializedName("strHomeTeam")
    var strHomeTeam: String? = "",

    @ColumnInfo(name = "strAwayTeam")
    @field:SerializedName("strAwayTeam")
    var strAwayTeam: String? = "",

    @ColumnInfo(name = "intHomeScore")
    @field:SerializedName("intHomeScore")
    var intHomeScore: String? = "",

    @ColumnInfo(name = "intAwayScore")
    @field:SerializedName("intAwayScore")
    var intAwayScore: String? = "",

    @ColumnInfo(name = "strHomeGoalsDetails")
    @field:SerializedName("strHomeGoalDetails")
    var strHomeGoalDetails: String? = "",

    @ColumnInfo(name = "strAwayGoalsDetails")
    @field:SerializedName("strAwayGoalDetails")
    var strAwayGoalDetails: String? = "",

    @ColumnInfo(name = "strHomeYellowCards")
    @field:SerializedName("strHomeYellowCards")
    var strHomeYellowCards: String? = "",

    @ColumnInfo(name = "strAwayYellowCards")
    @field:SerializedName("strAwayYellowCards")
    var strAwayYellowCards: String? = "",

    @ColumnInfo(name = "strHomeRedCards")
    @field:SerializedName("strHomeRedCards")
    var strHomeRedCards: String? = "",

    @ColumnInfo(name = "strAwayRedCards")
    @field:SerializedName("strAwayRedCards")
    var strAwayRedCards: String? = "",

    @ColumnInfo(name = "strSport")
    @field:SerializedName("strSport")
    var strSport: String? = "",

    @ColumnInfo(name = "dateEvent")
    @field:SerializedName("dateEvent")
    var dateEvent: String? = "",

    @ColumnInfo(name = "strDate")
    @field:SerializedName("strDate")
    var strDate: String? = "",

    @ColumnInfo(name = "strTime")
    @field:SerializedName("strTime")
    var strTime: String? = "",

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable