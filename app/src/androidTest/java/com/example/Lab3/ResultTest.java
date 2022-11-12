package com.example.Lab3;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class ResultTest {

    @Rule
    public ActivityScenarioRule<ResultActivity> activityRule =
            new ActivityScenarioRule<>(ResultActivity.class);


    @Test
    public void testIntentMock() {

        Context context = Mockito.mock(Context.class);
        Intent intent = ResultActivity.createIntent(context, "5");
        Assert.assertNotNull(intent);

        Assert.assertEquals("5", intent.getStringExtra("result"));


    }

    @Before
    public void intentInit(){
        Intents.init();
    }

    @Test
    public void testOnClickPlay() throws InterruptedException {
        onView(withId(R.id.play_btn)).perform(click());
        Thread.sleep(250);

        intending(toPackage(MainActivity.class.getName()));


    }

    @Test
    public void testOnClickMain() throws InterruptedException {
        onView(withId(R.id.main_btn)).perform(click());
        Thread.sleep(250);

        intending(toPackage(StartActivity.class.getName()));


    }

    @Test
    public void testOnClickExit() throws InterruptedException {
        onView(withId(R.id.exit_btn)).perform(click());
        Thread.sleep(250);

        intending(toPackage(LoginActivity.class.getName()));


    }


}
