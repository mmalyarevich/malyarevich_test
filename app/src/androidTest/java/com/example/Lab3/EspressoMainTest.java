package com.example.Lab3;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class EspressoMainTest {


    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void checkTimeVisible() {
        onView(withId(R.id.time)).check(matches(isDisplayed()));
    }

    @Test
    public void checkTestModeButtonYes(){
        // GIVEN
        onView(withId(R.id.yes_btn)).check(matches(isClickable()));

        // WHEN
        for (int i=0; i<10; i++){
            onView(withId(R.id.yes_btn)).perform(click());
        }

        // THEN
        onView(withId(R.id.points)).check(matches(withText("10")));
    }

    @Test
    public void checkTestModeButtonNo(){
        // GIVEN
        onView(withId(R.id.no_btn)).check(matches(isClickable()));

        // WHEN
        for (int i=0; i<10; i++){
            onView(withId(R.id.no_btn)).perform(click());
        }

        // THEN
        onView(withId(R.id.points)).check(matches(withText("0")));
    }

    @Test
    public void checkTestModeButton7Yes3No() {
        // GIVEN
        onView(withId(R.id.no_btn)).check(matches(isClickable()));
        onView(withId(R.id.yes_btn)).check(matches(isClickable()));

        // WHEN
        for (int i=0; i<3; i++){
            onView(withId(R.id.no_btn)).perform(click());
        }
        for (int i=0; i<7; i++){
            onView(withId(R.id.yes_btn)).perform(click());
        }

        // THEN
        onView(withId(R.id.points)).check(matches(withText("7")));
    }

    @Test
    public void checkTestModeButton1Yes1No() {
        // GIVEN
        onView(withId(R.id.no_btn)).check(matches(isClickable()));
        onView(withId(R.id.yes_btn)).check(matches(isClickable()));

        // WHEN
        onView(withId(R.id.no_btn)).perform(click());
        onView(withId(R.id.yes_btn)).perform(click());

        // THEN
        onView(withId(R.id.points)).check(matches(withText("1")));
    }

    @Test
    public void checkTestModeButtonNothing(){
        // GIVEN
        onView(withId(R.id.no_btn)).check(matches(isClickable()));
        onView(withId(R.id.yes_btn)).check(matches(isClickable()));

        // WHEN Nothing

        // THEN
        onView(withId(R.id.points)).check(matches(withText("0")));
    }

    @Test
    public void checkTestModeColorChanging(){
        // GIVEN
        onView(withId(R.id.no_btn)).check(matches(isClickable()));
        onView(withId(R.id.yes_btn)).check(matches(isClickable()));

        // WHEN
        onView(withId(R.id.yes_btn)).perform(click());
        // THEN
        onView(withId(R.id.color1)).check(matches(withText("Зелений")));
        onView(withId(R.id.color2)).check(matches(withText("Зелений")));

        // WHEN
        onView(withId(R.id.yes_btn)).perform(click());
        // THEN
        onView(withId(R.id.color1)).check(matches(withText("Рожевий")));
        onView(withId(R.id.color2)).check(matches(withText("Рожевий")));

        // WHEN
        onView(withId(R.id.no_btn)).perform(click());
        // THEN
        onView(withId(R.id.color1)).check(matches(withText("Синій")));
        onView(withId(R.id.color2)).check(matches(withText("Синій")));

        // WHEN AFTER
        for (int i=0; i<10; i++){
            onView(withId(R.id.no_btn)).perform(click());
        }
        // THEN
        onView(withId(R.id.color1)).check(matches(withText("Фіолетовий")));
        onView(withId(R.id.color2)).check(matches(withText("Фіолетовий")));

        // THEN
        onView(withId(R.id.points)).check(matches(withText("2")));
    }

}
