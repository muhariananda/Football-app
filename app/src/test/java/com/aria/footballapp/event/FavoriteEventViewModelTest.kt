package com.aria.footballapp.event

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.aria.footballapp.data.source.FootballRepository
import com.aria.footballapp.data.source.local.entity.EventsEntity
import com.aria.footballapp.ui.favorite.event.FavoriteEventViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteEventViewModelTest {
    private lateinit var viewModel: FavoriteEventViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var footballRepository: FootballRepository

    @Before
    fun setUp() {
        viewModel =
            FavoriteEventViewModel(
                footballRepository
            )
    }

    @Test
    fun getFavoriteEvent() {
        val dummyEvent = mock(PagedList::class.java) as PagedList<EventsEntity>
        `when`(dummyEvent.size).thenReturn(5)

        val events = MutableLiveData<PagedList<EventsEntity>>()
        events.value = dummyEvent

        `when`(footballRepository.getFavoriteEvents()).thenReturn(events)
        val eventsEntity = viewModel.getFavorite().value
        verify<FootballRepository>(footballRepository).getFavoriteEvents()

        assertNotNull(eventsEntity)
        assertEquals(5, eventsEntity?.size)

        val observer = mock(Observer::class.java) as Observer<List<EventsEntity>>
        viewModel.getFavorite().observeForever(observer)
        verify(observer).onChanged(dummyEvent)
    }
}