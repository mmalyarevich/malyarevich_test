package com.example.Lab3;

import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Map;

public class MainActivityTest extends TestCase {

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
        assertTrue(map_length == 8);
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