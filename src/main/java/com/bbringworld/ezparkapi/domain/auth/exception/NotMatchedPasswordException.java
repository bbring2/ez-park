package com.bbringworld.ezparkapi.domain.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotMatchedPasswordException extends RuntimeException {

    public NotMatchedPasswordException() {

    }

    public NotMatchedPasswordException(String message) {
        super(message);
    }

    public NotMatchedPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
