package com.bbringworld.ezparkapi.global.exception.advice;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TotalServerException extends RuntimeException {

    public TotalServerException(String message) {
        super(message);
    }

    public TotalServerException(String message, Throwable cause) {
        super(message, cause);
    }

}
