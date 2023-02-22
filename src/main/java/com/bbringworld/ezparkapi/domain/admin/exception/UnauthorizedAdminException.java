package com.bbringworld.ezparkapi.domain.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedAdminException extends RuntimeException {

    public UnauthorizedAdminException() {
    }

    public UnauthorizedAdminException(String message) {
        super(message);
    }

    public UnauthorizedAdminException(String message, Throwable cause) {
        super(message, cause);
    }

}
