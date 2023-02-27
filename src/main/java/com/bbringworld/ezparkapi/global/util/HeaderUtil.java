package com.bbringworld.ezparkapi.global.util;

import jakarta.servlet.http.HttpServletRequest;

public class HeaderUtil {

    private final static String HEADER_AUTHORIZATION = "Authorization";
    private final static String PREFIX = "Bearer ";

    public static String getAccessToken(HttpServletRequest request) {
        String headerValue = request.getHeader(HEADER_AUTHORIZATION);

        if(headerValue == null) {
            return null;
        }

        if(headerValue.startsWith(PREFIX)) {
            return headerValue.substring(PREFIX.length());
        }

        return null;
    }
}
