package com.aria.footballapp.vo

import com.aria.footballapp.vo.Status.*

class Resource<T>(val status: Status?, val data: T?, private val message: String?) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(msg: String?, data: T?): Resource<T> {
            return Resource(ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(LOADING, data, null)
        }
    }
}