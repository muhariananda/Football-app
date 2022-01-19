package com.aria.footballapp.di

import android.content.Context
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.LocalRepository
import com.aria.footballapp.data.source.local.room.FootballDatabase
import com.aria.footballapp.data.source.remote.RemoteRepository
import com.aria.footballapp.utils.AppExecutors

class Injection {
    companion object {
        fun provideRepository(context: Context): FootballRepository {

            val database = FootballDatabase.getInstance(context)

            val remoteRepository = RemoteRepository.instance()
            val localRepository = LocalRepository.getInstance(database.footballDao())
            val appExecutors = AppExecutors()

            return FootballRepository.getInstance(localRepository, remoteRepository, appExecutors)
        }
    }
}