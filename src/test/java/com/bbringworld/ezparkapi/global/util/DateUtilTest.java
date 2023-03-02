package com.bbringworld.ezparkapi.global.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @Test
    void str_to_ld() {
        String ldt = "2022-01-23";
        System.out.println(DateUtil.strToLd(ldt));
        System.out.println(ldt.length());
    }

    @Test
    void ld_to_str() {
        System.out.println(DateUtil.ldToStr(LocalDate.of(2022,1,3)));
    }

    @Test
    void create() {
        DateUtil dateUtil = new DateUtil();
        assertNotNull(dateUtil);
    }

}