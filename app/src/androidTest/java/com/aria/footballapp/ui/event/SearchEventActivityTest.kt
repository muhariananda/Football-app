package com.aria.footballapp.ui.event

import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.aria.footballapp.R
import com.aria.footballapp.ui.home.SearchActivity
import com.aria.footballapp.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchEventActivityTest {

    @get: Rule
    var activityRule = ActivityTestRule(SearchActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun searchEvent() {
        //Check search view display
        onView(withId(R.id.search_view)).check(matches(isDisplayed()))
        onView(withId(R.id.search_view)).perform(click())

        //input and search "Liverpool"
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeTextIntoFocusedView("Liverpool"),
            pressImeActionButton()
        )
        onView(withId(R.id.rv_search)).check(matches(isDisplayed()))

        //clear, input and search "Barcelona"
        onView(isAssignableFrom(EditText::class.java)).perform(clearText())
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeTextIntoFocusedView("Barcelona"),
            pressImeActionButton()
        )
        onView(withId(R.id.rv_search)).check(matches(isDisplayed()))

        //check if match not found
        onView(isAssignableFrom(EditText::class.java)).perform(clearText())
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeTextIntoFocusedView("Arema"),
            pressImeActionButton()
        )
        onView(withId(R.id.tv_match_not_found)).check(matches(isDisplayed()))

        //clear
        onView(isAssignableFrom(EditText::class.java)).perform(clearText())
    }
}