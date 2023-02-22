package com.bbringworld.ezparkapi.domain.membership.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateMembershipException extends RuntimeException {

    public DuplicateMembershipException() {

    }

    public DuplicateMembershipException(String message) {
        super(message);
    }

    public DuplicateMembershipException(String message, Throwable cause) {
        super(message, cause);
    }

}
