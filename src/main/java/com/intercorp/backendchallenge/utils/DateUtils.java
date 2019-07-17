package com.intercorp.backendchallenge.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static final int WORLD_LIFE_EXPECTANCY = 79;

    public static Date addYears(Date baseDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(baseDate);
        calendar.add(Calendar.YEAR, WORLD_LIFE_EXPECTANCY);
        return calendar.getTime();
    }
}
