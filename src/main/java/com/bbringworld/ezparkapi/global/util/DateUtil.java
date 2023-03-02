package com.bbringworld.ezparkapi.global.util;

import java.time.LocalDate;

public class DateUtil {

    public static LocalDate strToLd(String ldt) {
        int year = Integer.parseInt(ldt.substring(0,4));
        int month = Integer.parseInt(ldt.substring(5,7));
        int day = Integer.parseInt(ldt.substring(8));

        return LocalDate.of(year, month, day);
    }

    public static String ldToStr(LocalDate ld) {
        return String.valueOf(ld);
    }
}
