package com.bbringworld.ezparkapi.domain.coupon.adaptor.in;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CouponRegistryTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /*@Test
    void notEmpty_validation() {
        CouponRegistry couponRegistry = new CouponRegistry();
        Set<ConstraintViolation<PostRequest>> violations = validator.validate(postRequest);
    }*/

}