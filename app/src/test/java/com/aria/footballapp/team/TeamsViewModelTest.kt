package com.aria.footballapp.team

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.utils.FakeDataDummy
import com.aria.footballapp.ui.team.TeamsViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TeamsViewModelTest {
    private lateinit var viewModel: TeamsViewModel

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var footballRepository: FootballRepository

    @Before
    fun setUp() {
        viewModel =
            TeamsViewModel(footballRepository)
    }

    @Test
    fun getTeam() {
        val dummyTeam = FakeDataDummy.generateTeam()
        val league = "English Premier League"
        val teams = MutableLiveData<List<TeamsEntity>>()
        teams.value = dummyTeam

        `when`(footballRepository.getAllTeams(league)).thenReturn(teams)
        viewModel.initTeam(league)
        val teamsEntity = viewModel.teams?.value
        verify<FootballRepository>(footballRepository).getAllTeams(league)

        assertNotNull(teamsEntity)
        assertEquals(5, teamsEntity?.size)

        val observer = mock(Observer::class.java) as Observer<List<TeamsEntity>>
        viewModel.teams?.observeForever(observer)
        verify(observer).onChanged(dummyTeam)
    }
}