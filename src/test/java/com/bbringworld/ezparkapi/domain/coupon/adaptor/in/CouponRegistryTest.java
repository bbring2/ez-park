package com.bbringworld.ezparkapi.domain.coupon.adaptor.in;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CouponRegistryTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeAll
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void notEmpty_validation() {
        CouponRegistry couponRegistry = CouponRegistry.builder()
                .adminId(2L)
                .expiredDate("2023-03-31")
                .issuedDate("2023-03-01")
                .rate("10")
                .build();
        Set<ConstraintViolation<CouponRegistry>> violations = validator.validate(couponRegistry);

        for (ConstraintViolation<CouponRegistry> violation : violations) {
            System.err.println(violation.getMessage());
        }
    }

}