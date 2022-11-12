package com.example.Lab3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Map;

public class MainActivityTest extends TestCase {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    public String[] tags = new String[]{"Червоний:-65536", "Зелений:-144357", "Помаранчевий:-26368",
        "Жовтий:-598252", "Блакитний:-16728876", "Синій:-14401322", "Фіолетовий:-9422635",
        "Чорний:-16777216", "Рожевий:-841281027", };

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testOnCreate() {
    }

    @Test
    public void testArray2dict() {
        Map map = MainActivity.array2dict(tags);
        int map_length = map.size();
        assertTrue(map_length == 9);
    }

    @Test
    public void testArray2dictOneElement() {
        Map map = MainActivity.array2dict(new String[]{tags[0]});
        int map_length = map.size();
        assertTrue(map_length == 1);
    }

    @Test
    public void testSetTestMode() {
        int status = 0;
        SharedPreferences sharedPref = mock(SharedPreferences.class);
        SharedPreferences.Editor editor = mock(SharedPreferences.Editor.class);
        when(sharedPref.edit()).thenReturn(editor);
        when(editor.putInt("testing_mode", status)).thenReturn(editor);
        MainActivity.setTestMode(sharedPref, status);

        verify(editor, atMostOnce()).putInt("testing_mode", status);
        verify(editor, atLeastOnce()).apply();
        verify(editor, times(1)).apply();
    }

    public void testOnYesClick() {
    }

    public void testOnNoClick() {
    }

    public void testChangeColors() {
    }

    public void testRandomChangeColors() {
    }

    public void testFixedChangeColors() {
    }
}