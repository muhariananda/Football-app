package com.aria.footballapp.data.source.local.entity


import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "team_table")
data class TeamsEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    @SerializedName("idTeam")
    var idTeam: String,

    @ColumnInfo(name = "strTeam")
    @SerializedName("strTeam")
    var strTeam: String? = "",

    @ColumnInfo(name = "strSport")
    @SerializedName("strSport")
    var strSport: String? = "",

    @ColumnInfo(name = "strStadiumLocation")
    @SerializedName("strStadiumLocation")
    var strStadiumLocation: String? = "",

    @ColumnInfo(name = "strCountry")
    @SerializedName("strCountry")
    var strCountry: String? = "",

    @ColumnInfo(name = "strStadiumThumb")
    @SerializedName("strStadiumThumb")
    var strStadiumThumb: String? = "",

    @ColumnInfo(name = "strInstagram")
    @SerializedName("strInstagram")
    var strInstagram: String? = "",

    @ColumnInfo(name = "strDescriptionEN")
    @SerializedName("strDescriptionEN")
    var strDescriptionEN: String? = "",

    @ColumnInfo(name = "strWebsite")
    @SerializedName("strWebsite")
    var strWebsite: String? = "",

    @ColumnInfo(name = "strYoutube")
    @SerializedName("strYoutube")
    var strYoutube: String? = "",

    @ColumnInfo(name = "strTwitter")
    @SerializedName("strTwitter")
    var strTwitter: String? = "",

    @ColumnInfo(name = "strGender")
    @SerializedName("strGender")
    var strGender: String? = "",

    @ColumnInfo(name = "strStadium")
    @SerializedName("strStadium")
    var strStadium: String? = "",

    @ColumnInfo(name = "strFacebook")
    @SerializedName("strFacebook")
    var strFacebook: String? = "",

    @ColumnInfo(name = "strBadge")
    @SerializedName("strTeamBadge")
    var strTeamBadge: String? = "",

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable