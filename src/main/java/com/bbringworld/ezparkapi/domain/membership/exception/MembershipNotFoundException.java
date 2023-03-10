package com.bbringworld.ezparkapi.domain.membership.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MembershipNotFoundException extends RuntimeException{

    public MembershipNotFoundException(String message) {
        super(message);
    }

    public MembershipNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
