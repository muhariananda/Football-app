package com.aria.footballapp.data.source.remote.respon


import com.aria.footballapp.data.source.local.entity.TableEntity
import com.google.gson.annotations.SerializedName

data class TableResponse(

	@field:SerializedName("table")
	val table: List<TableEntity>? = null
)