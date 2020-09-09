package com.example.demo.Services;

import java.util.Calendar;

public class DayOfWeek {

    public DayOfWeek(){

    }

    public int returnDayOfWeek(){
        Calendar today = Calendar.getInstance();
        int day = today.get(Calendar.DATE);
        int month = today.get(Calendar.MONTH) + 1;
        int year = today.get(Calendar.YEAR);

        if (month < 3) {
            month += 12;
            year -= 1;
        }

        int k = year % 100;
        int j = year / 100;

// 0 = Saturday, 1 = Sunday, ...
        int dayOfWeek = ((day + (((month + 1) * 26) / 10) +
                k + (k / 4) + (j / 4)) + (5 * j)) % 7;

        return dayOfWeek;
    }
}
