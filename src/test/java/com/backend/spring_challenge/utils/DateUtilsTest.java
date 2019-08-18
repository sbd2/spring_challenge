package com.backend.spring_challenge.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateUtilsTest {

    private static final int BASE_YEAR = 2000;

    @Test
    public void addYears() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(BASE_YEAR, 2, 15);
        Date newDate = DateUtils.addYears(calendar.getTime(), DateUtils.WORLD_LIFE_EXPECTANCY);
        calendar.setTime(newDate);
        Assert.assertEquals(calendar.get(Calendar.YEAR), BASE_YEAR + DateUtils.WORLD_LIFE_EXPECTANCY);
    }
}