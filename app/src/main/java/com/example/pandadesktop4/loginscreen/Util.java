package com.example.pandadesktop4.loginscreen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by pandadesktop4 on 27/7/17.
 */

public class Util {

    public static Date getDate(Integer month, Integer year) {
        Integer currentMonth = month + 1;
        Integer currentYear = year + 1900;
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse("1." + currentMonth.toString() + "." + currentYear.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Date> getDatesForMonth(Integer month, Integer year) {
        Integer currentMonth = month + 1;
        Integer currentYear = year + 1900;
        List<Date> dates = new ArrayList<>();
        Date date = null;
        try {

            date = new SimpleDateFormat("dd.MM.yyyy").parse("0." + currentMonth.toString() + "." + currentYear.toString());


        } catch (ParseException e) {
            e.printStackTrace();
        }

        while (true) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 1);
            date = c.getTime();
            if (date.getMonth() != month)
                break;
            dates.add(date);
        }
        return dates;
    }
}
