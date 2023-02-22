package com.bbringworld.ezparkapi.domain.spot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class SpotInFullException extends RuntimeException {

    public SpotInFullException() {

    }

    public SpotInFullException(String message) {
        super(message);
    }

    public SpotInFullException(String message, Throwable cause) {
        super(message, cause);
    }

}
