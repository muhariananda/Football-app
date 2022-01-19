package com.aria.footballapp.data.source.local.entity


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeaguesEntity(

    @field:SerializedName("idLeague")
    var idLeague: String,

    @field:SerializedName("strLeague")
    var strLeague: String,

    @field:SerializedName("strSport")
    var strSport: String? = "",

    @field:SerializedName("strDescriptionEN")
    var strDescriptionEN: String,

    @field:SerializedName("strWebsite")
    var strWebsite: String? = "",

    @field:SerializedName("strYoutube")
    var strYoutube: String? = "",

    @field:SerializedName("strBadge")
    var strBadge: String? = "",

    @field:SerializedName("strTwitter")
    var strTwitter: String? = "",

    @field:SerializedName("strGender")
    var strGender: String? = "",

    @field:SerializedName("strNaming")
    var strNaming: String? = "",

    @field:SerializedName("strFanart2")
    var strFanart2: String? = "",

    @field:SerializedName("strFacebook")
    var strFacebook: String? = "",

    @field:SerializedName("strCountry")
    var strCountry: String? = "",

    @field:SerializedName("strLogo")
    var strLogo: String? = "",

    @field:SerializedName("strPoster")
    var strPoster: String? = ""
) : Parcelable