package com.aria.footballapp.team

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.ui.favorite.team.FavoriteTeamViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTeamViewModelTest {
    private lateinit var viewModel: FavoriteTeamViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var footballRepository: FootballRepository

    @Before
    fun setUp() {
        viewModel = FavoriteTeamViewModel(
            footballRepository
        )
    }

    @Test
    fun getFavoriteTeam() {
        val dummyTeam = mock(PagedList::class.java) as PagedList<TeamsEntity>
        `when`(dummyTeam.size).thenReturn(5)
        val teams = MutableLiveData<PagedList<TeamsEntity>>()
        teams.value = dummyTeam

        `when`(footballRepository.getFavoriteTeam()).thenReturn(teams)
        val teamsEntity = viewModel.getFavorite().value
        verify<FootballRepository>(footballRepository).getFavoriteTeam()

        assertNotNull(teamsEntity)
        assertEquals(5, teamsEntity?.size)

        val observer = mock(Observer::class.java) as Observer<List<TeamsEntity>>
        viewModel.getFavorite().observeForever(observer)
        verify(observer).onChanged(dummyTeam)
    }
}