package com.bbringworld.ezparkapi.domain.guest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GuestNotFoundException extends RuntimeException {

    public GuestNotFoundException() {

    }

    public GuestNotFoundException(String message) {
        super(message);
    }

    public GuestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
