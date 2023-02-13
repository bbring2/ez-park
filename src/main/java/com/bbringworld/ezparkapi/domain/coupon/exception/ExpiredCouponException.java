package com.bbringworld.ezparkapi.domain.coupon.exception;


public class ExpiredCouponException extends RuntimeException {

    public ExpiredCouponException(String message) {
        super(message);
    }
}
