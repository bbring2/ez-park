package com.bbringworld.ezparkapi.global.util;

import java.util.Locale;
import java.util.Random;

public class StringUtil {

    //FIXME 1) SHOULD NOT BE DUPLICATED 2) THE LENGTH SHOULD BE 10
    public static String makeCode() {
        Random random = new Random();

        return random
                .ints(97, 123)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString()
                .toUpperCase(Locale.ROOT);
    }
}
