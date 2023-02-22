package com.bbringworld.ezparkapi.domain.guest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnmatchedTimeException extends IllegalArgumentException {

    public UnmatchedTimeException() {
    }

    public UnmatchedTimeException(String message) {
        super(message);
    }

    public UnmatchedTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
