package com.bbringworld.ezparkapi.global.exception.advice;

import com.bbringworld.ezparkapi.domain.coupon.exception.ExpiredCouponException;
import com.bbringworld.ezparkapi.global.exception.output.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdviceController {

    private static String getExceptionName(Exception e) {
        return e.getClass().getName();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ExpiredCouponException.class)
    public ErrorInfo handleIssuedCouponExistException(ExpiredCouponException e) {
        return new ErrorInfo(e.getClass().getSimpleName(), getExceptionName(e));
    }
}
