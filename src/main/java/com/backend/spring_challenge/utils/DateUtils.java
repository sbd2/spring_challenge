package com.backend.spring_challenge.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static final int WORLD_LIFE_EXPECTANCY = 79;

    public static Date addYears(Date baseDate, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(baseDate);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }
}
