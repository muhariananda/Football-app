package com.aria.footballapp.event

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.utils.FakeDataDummy
import com.aria.footballapp.ui.event.DetailEventViewModel
import com.aria.footballapp.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailEventViewModelTest {
    private lateinit var viewModel: DetailEventViewModel
    private val idEvent = FakeDataDummy.generateAllLastEvent()[0].idEvent

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var footballRepository: FootballRepository

    @Before
    fun setUp() {
        viewModel = DetailEventViewModel(
            footballRepository
        )
        viewModel.idEvent.value = idEvent
    }

    @Test
    fun getDetailEvent() {
        val dummyEvent = Resource.success(FakeDataDummy.generateAllLastEvent()[0])
        val event = MutableLiveData<Resource<EventsEntity>>()
        event.value = dummyEvent

        `when`(footballRepository.getDetailEvent(idEvent)).thenReturn(event)

        val observer = mock(Observer::class.java) as Observer<Resource<EventsEntity>>
        viewModel.initEvent(idEvent)
        viewModel.data?.observeForever(observer)

        verify(observer).onChanged(dummyEvent)
    }
}