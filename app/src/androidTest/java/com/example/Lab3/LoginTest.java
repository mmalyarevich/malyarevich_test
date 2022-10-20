package com.example.Lab3;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class LoginTest {
    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Rule
    public IntentsTestRule<LoginActivity> intentsTestRule =
            new IntentsTestRule<>(LoginActivity.class);


    @Test
    public void checkEmailEditVisible() {
        onView(withId(R.id.username)).check(matches(isDisplayed()));
    }
    @Test
    public void checkPasswordEditVisible() {
        onView(withId(R.id.password)).check(matches(isDisplayed()));
    }

    @Test
    public void testLoginWithCorrectCredentials() {
        onView(withId(R.id.username)).perform(typeText("test@gmail.com"));
        onView(withId(R.id.password)).perform(typeText("123456"));
        onView(withId(R.id.loginButton)).perform(click());

//        intended(hasComponent(StartActivity.class.getName()));

        Intent i = new Intent();
        Instrumentation.ActivityResult  result = new Instrumentation.ActivityResult(Activity.RESULT_OK, i);
        intending(toPackage(StartActivity.class.getName()));


    }

    @Test
    public void testLoginWithWrongCredentials() {
        onView(withId(R.id.username)).perform(typeText("test1@gmail.com"));
        onView(withId(R.id.password)).perform(typeText("123456"));
        onView(withId(R.id.loginButton)).perform(click());

        onView(withId(R.id.checklogin)).check(matches(withText("False")));

    }



}
