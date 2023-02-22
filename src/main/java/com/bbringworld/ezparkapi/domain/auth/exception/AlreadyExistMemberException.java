package com.bbringworld.ezparkapi.domain.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistMemberException extends RuntimeException {

    public AlreadyExistMemberException() {
    }

    public AlreadyExistMemberException(String message) {
        super(message);
    }

    public AlreadyExistMemberException(String message, Throwable cause) {
        super(message, cause);
    }

}
