package com.aria.footballapp.event

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.utils.FakeDataDummy
import com.aria.footballapp.ui.event.EventNextViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EventNextViewModelTest {
    private lateinit var viewModel: EventNextViewModel

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var footballRepository: FootballRepository

    @Before
    fun setUp() {
        viewModel =
            EventNextViewModel(footballRepository)
    }

    @Test
    fun getNextEvent() {
        val dummyEvent = FakeDataDummy.generateEventNext()
        val idLeague = dummyEvent[0].idLeague
        val events = MutableLiveData<List<EventsEntity>>()
        events.value = dummyEvent

        `when`(footballRepository.getNextEvent(idLeague)).thenReturn(events)
        viewModel.initNextEvent(idLeague)
        val eventsEntity = viewModel.data?.value
        verify<FootballRepository>(footballRepository).getNextEvent(idLeague)

        assertNotNull(eventsEntity)
        assertEquals(5, eventsEntity?.size)

        val observer = mock(Observer::class.java) as Observer<List<EventsEntity>>
        viewModel.data?.observeForever(observer)
        verify(observer).onChanged(dummyEvent)
    }
}