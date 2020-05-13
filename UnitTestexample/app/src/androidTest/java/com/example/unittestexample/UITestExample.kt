package com.example.unittestexample

import android.app.ActionBar
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

//testOptions gradle
//disable window animation scale
// transition animation scale
// animator duration scale

class InstrumentationTestExample {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Before
    fun setUp() {
        val intent = Intent()
        activityRule.launchActivity(intent)
    }

    @Test
    fun appLaunchSuccess() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun progressBarVisibleFirstTime() {
        onView(withId(R.id.progressBar))
            .check(matches(isDisplayed()))
    }

    @Test
    fun actionBarTitleNotEmpty() {
        val actionBar: androidx.appcompat.app.ActionBar? = activityRule.activity.supportActionBar
        Assert.assertNotNull(actionBar?.title)
    }

    @Test
    fun recyclerViewIsDisplayed() {
        Thread.sleep(3000)

        val recyclerView: RecyclerView = activityRule.activity.findViewById(R.id.recyclerView)
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))

        Assert.assertNotSame(0, recyclerView.adapter?.itemCount)
    }

    @Test
    fun recyclerViewTestSwipeUp() {
        onView(withId(R.id.recyclerView)).perform(ViewActions.swipeUp())
    }

    @Test
    fun recyclerViewTestSwipeDown() {
        onView(withId(R.id.recyclerView)).perform(ViewActions.swipeDown())
    }
}

