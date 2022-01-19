package com.aria.footballapp.team

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.TeamsEntity
import com.aria.footballapp.utils.FakeDataDummy
import com.aria.footballapp.ui.team.DetailTeamViewModel
import com.aria.footballapp.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTeamViewModelTest {
    private lateinit var viewModel: DetailTeamViewModel
    private val idTeam = FakeDataDummy.generateTeam()[0].idTeam

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var footballRepository: FootballRepository

    @Before
    fun setUp() {
        viewModel =
            DetailTeamViewModel(footballRepository)
        viewModel.idTeam.value = idTeam
    }

    @Test
    fun getDetailTeam() {
        val dummyTeam = Resource.success(FakeDataDummy.generateTeam()[0])
        val team = MutableLiveData<Resource<TeamsEntity>>()
        team.value = dummyTeam

        `when`(footballRepository.getDetailTeam(idTeam)).thenReturn(team)

        val observer = mock(Observer::class.java) as Observer<Resource<TeamsEntity>>
        viewModel.initTeam(idTeam)
        viewModel.data?.observeForever(observer)

        verify(observer).onChanged(dummyTeam)
    }
}