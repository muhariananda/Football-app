package com.aria.footballapp.league

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.LeaguesEntity
import com.aria.footballapp.utils.FakeDataDummy
import com.aria.footballapp.ui.league.LeagueViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LeagueViewModelTest {

    private lateinit var viewModel: LeagueViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var footballRepository: FootballRepository

    @Before
    fun setUp() {
        viewModel =
            LeagueViewModel(footballRepository)
    }

    @Test
    fun getLeague() {
        val dummyLeague = FakeDataDummy.generateAllLeague()
        val leagues = MutableLiveData<List<LeaguesEntity>>()
        leagues.value = dummyLeague
        `when`(footballRepository.getAllLeague()).thenReturn(leagues)
        viewModel.initLeague()
        val leaguesEntity = viewModel.data?.value
        verify(footballRepository).getAllLeague()

        assertNotNull(leaguesEntity)
        assertEquals(10, leaguesEntity?.size)

        val observer = mock(Observer::class.java) as Observer<List<LeaguesEntity>>
        viewModel.data?.observeForever(observer)
        verify(observer).onChanged(dummyLeague)
    }

}