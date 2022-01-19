package com.aria.footballapp.league

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.LeaguesEntity
import com.aria.footballapp.utils.FakeDataDummy
import com.aria.footballapp.ui.league.DetailLeagueViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailLeagueViewModelTest {
    private lateinit var viewModel: DetailLeagueViewModel
    private val dummyLeagues = FakeDataDummy.generateAllLeague()[0]
    private val idLeague = dummyLeagues.idLeague


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var footballRepository: FootballRepository

    @Before
    fun setUp() {
        viewModel = DetailLeagueViewModel(
            footballRepository
        )
    }

    @Test
    fun getDetailLeague() {
        val leagues = MutableLiveData<LeaguesEntity>()
        leagues.value = dummyLeagues

        `when`(footballRepository.getDetailLeague(idLeague)).thenReturn(leagues)
        viewModel.initLeague(idLeague)
        val leaguesEntity = viewModel.leagues?.value as LeaguesEntity
        verify(footballRepository).getDetailLeague(idLeague)

        assertNotNull(leaguesEntity)
        assertEquals(dummyLeagues.idLeague, leaguesEntity.idLeague)
        assertEquals(dummyLeagues.strLeague, leaguesEntity.strLeague)
        assertEquals(dummyLeagues.strBadge, leaguesEntity.strBadge)
        assertEquals(dummyLeagues.strDescriptionEN, leaguesEntity.strDescriptionEN)

        val observer = mock(Observer::class.java) as Observer<LeaguesEntity>
        viewModel.leagues?.observeForever(observer)
        verify(observer).onChanged(dummyLeagues)
    }
}