package com.aria.footballapp.event

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.utils.FakeDataDummy
import com.aria.footballapp.ui.event.EventSearchViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EventSearchViewModelTest {
    private lateinit var viewModel: EventSearchViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var footballRepository: FootballRepository

    @Before
    fun setUp() {
        viewModel = EventSearchViewModel(
            footballRepository
        )
    }

    @Test
    fun getSearchEvent() {
        val dummyEvent = FakeDataDummy.generateEventNext()
        val query : String = "Newcastle vs Chelsea"
        val events = MutableLiveData<List<EventsEntity>>()
        events.value = dummyEvent

        `when`(footballRepository.getSearchEvent(query)).thenReturn(events)
        viewModel.init(query)
        val eventsEntity = viewModel.data?.value
        verify<FootballRepository>(footballRepository).getSearchEvent(query)

        assertNotNull(eventsEntity)
        assertEquals(5, eventsEntity?.size)

        val observer = mock(Observer::class.java) as Observer<List<EventsEntity>>
        viewModel.data?.observeForever(observer)
        verify(observer).onChanged(dummyEvent)
    }
}