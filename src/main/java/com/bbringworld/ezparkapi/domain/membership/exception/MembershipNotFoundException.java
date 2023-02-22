package com.bbringworld.ezparkapi.domain.membership.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MembershipNotFoundException extends RuntimeException{

    public MembershipNotFoundException() {

    }

    public MembershipNotFoundException(String message) {
        super(message);
    }

    public MembershipNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
