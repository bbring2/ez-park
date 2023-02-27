package com.bbringworld.ezparkapi.domain.auth.application.provider;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class AuthProviderTest {

    @Test
    void make_compile_error() {
        String str = "Too random";
        try {
            //write codes which exception can be expected.
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            //write codes which handle NumberFormatException from the codes in try
            System.out.println("THIS IS NumberFormatException : " + e.getMessage());
        } catch (Exception e) {
            //write codes which handle any Exception from the code in try.
            System.out.println("THIS IS Exception : " + e.getMessage());
        } finally {
            System.out.println("THIS IS Final handling!!!");
        }
    }
}