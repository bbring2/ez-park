package com.bbringworld.ezparkapi.global.util;

import jakarta.validation.constraints.AssertTrue;
import org.bson.assertions.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void check_random_code() {
        String result = StringUtil.makeCode();
        Assertions.isTrue(result, result.length() == 10);
    }

    @Test
    void check_mobile_code() {
        System.out.println(StringUtil.makeCode());
    }

}