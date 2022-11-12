package com.example.Lab3;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSubstring;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.view.View;

import androidx.test.espresso.action.TypeTextAction;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


@RunWith(AndroidJUnit4.class)
@SmallTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {
    private View decorView;
    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void A_checkEmailEditVisible() {
        onView(withId(R.id.username)).check(matches(isDisplayed()));
    }
    @Test
    public void B_checkPasswordEditVisible() {
        onView(withId(R.id.password)).check(matches(isDisplayed()));
    }


    @Before
    public void intentInit(){
        Intents.init();
    }

    @Test
    public void D_testLoginWithCorrectCredentials() throws InterruptedException {
        onView(withId(R.id.username)).perform(new TypeTextAction("test@test.com"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(new TypeTextAction("United11"), closeSoftKeyboard());
//        onView(withId(R.id.password)).perform(closeSoftKeyboard());
        Thread.sleep(250);
        onView(withId(R.id.loginButton)).perform(click());

        Intent i = new Intent();
        Instrumentation.ActivityResult  result = new Instrumentation.ActivityResult(Activity.RESULT_OK, i);
        intending(toPackage(StartActivity.class.getName()));
        onView(withId(R.id.checklogin)).check(matches(withSubstring("True")));


    }

    @After
    public void intentRelease(){
        Intents.release();
    }

//    @Before
//    public void setUp() {
//        activityRule.getScenario().onActivity(new ActivityScenario.ActivityAction<LoginActivity>() {
//            @Override
//            public void perform(LoginActivity activity) {
//                decorView = activity.getWindow().getDecorView();
//            }
//        });
//    }

    @Test
    public void C_testLoginWithWrongCredentials() throws InterruptedException {
        onView(withId(R.id.username)).perform(new TypeTextAction("test@test.com"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(new TypeTextAction("United12"), closeSoftKeyboard());
        Thread.sleep(250);
        onView(withId(R.id.loginButton)).perform(click());
        Thread.sleep(250);

        intending(toPackage(StartActivity.class.getName()));
        onView(withId(R.id.checklogin)).check(matches(withSubstring("False")));


//        onView(withText("Authentication failed."))
//                .inRoot(withDecorView(Matchers.is(decorView)))// Here we use decorView
//                .check(matches(isDisplayed()));


//        onView(withId(R.id.checklogin)).check(matches(withText("False")));



    }



}
