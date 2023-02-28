package com.bbringworld.ezparkapi.global.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @Test
    void str_to_ldt() {
        String ldt = "2022-01-23";
        System.out.println(DateUtil.strToLdt(ldt));
    }
}