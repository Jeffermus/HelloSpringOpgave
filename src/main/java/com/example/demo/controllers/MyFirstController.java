package com.example.demo.controllers;


import com.example.demo.Services.DayOfWeek;
import com.example.demo.Services.WorldSimplestCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@Controller
public class MyFirstController {
    @GetMapping("/fredag")
    @ResponseBody
    public String friday(){
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


           if(dayOfWeek == 6){
               return "yes";
        }
           return "no";
    }

    @GetMapping("/dayOfWeek")
    @ResponseBody
    public String dayOfWeek() {
        DayOfWeek dayObj = new DayOfWeek();

        int day = dayObj.returnDayOfWeek();
        if (day == 0) {
            return "Lørdag";
        }

        if (day == 1) {
            return "Søndag";
        }
        if (day == 2) {
            return "Mandag";
        }

        if (day == 3) {
            return "Tirsdag";
        }

        if (day == 4) {
            return "Onsdag";
        }

        if (day == 5) {
            return "Torsdag";
        }

        if (day == 6) {
            return "Fredag";
        }

        return null;

    }

}
