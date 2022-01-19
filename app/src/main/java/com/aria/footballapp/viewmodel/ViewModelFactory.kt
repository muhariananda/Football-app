package com.aria.footballapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.di.Injection
import com.aria.footballapp.ui.event.DetailEventViewModel
import com.aria.footballapp.ui.event.EventLastViewModel
import com.aria.footballapp.ui.event.EventNextViewModel
import com.aria.footballapp.ui.event.EventSearchViewModel
import com.aria.footballapp.ui.favorite.event.FavoriteEventViewModel
import com.aria.footballapp.ui.favorite.team.FavoriteTeamViewModel
import com.aria.footballapp.ui.league.DetailLeagueViewModel
import com.aria.footballapp.ui.league.LeagueViewModel
import com.aria.footballapp.ui.table.TableViewModel
import com.aria.footballapp.ui.team.DetailTeamViewModel
import com.aria.footballapp.ui.team.TeamSearchViewModel
import com.aria.footballapp.ui.team.TeamsViewModel

class ViewModelFactory(private val footballRepository: FootballRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun instance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LeagueViewModel::class.java) -> {
                LeagueViewModel(footballRepository) as T
            }
            modelClass.isAssignableFrom(DetailLeagueViewModel::class.java) -> {
                DetailLeagueViewModel(
                    footballRepository
                ) as T
            }
            modelClass.isAssignableFrom(TeamsViewModel::class.java) -> {
                TeamsViewModel(footballRepository) as T
            }
            modelClass.isAssignableFrom(EventNextViewModel::class.java) -> {
                EventNextViewModel(
                    footballRepository
                ) as T
            }
            modelClass.isAssignableFrom(EventLastViewModel::class.java) -> {
                EventLastViewModel(
                    footballRepository
                ) as T
            }
            modelClass.isAssignableFrom(DetailEventViewModel::class.java) -> {
                DetailEventViewModel(
                    footballRepository
                ) as T
            }
            modelClass.isAssignableFrom(DetailTeamViewModel::class.java) -> {
                DetailTeamViewModel(
                    footballRepository
                ) as T
            }
            modelClass.isAssignableFrom(EventSearchViewModel::class.java) -> {
                EventSearchViewModel(
                    footballRepository
                ) as T
            }

            modelClass.isAssignableFrom(FavoriteEventViewModel::class.java) -> {
                FavoriteEventViewModel(
                    footballRepository
                ) as T
            }

            modelClass.isAssignableFrom(FavoriteTeamViewModel::class.java) -> {
                FavoriteTeamViewModel(
                    footballRepository
                ) as T
            }

            modelClass.isAssignableFrom(TeamSearchViewModel::class.java) -> {
                TeamSearchViewModel(
                    footballRepository
                ) as T
            }

            modelClass.isAssignableFrom(TableViewModel::class.java) -> {
                TableViewModel(footballRepository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
        }

    }
}