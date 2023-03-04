package com.bbringworld.ezparkapi.domain.coupon.application.provider;

import com.bbringworld.ezparkapi.domain.coupon.adaptor.in.CouponRegistry;
import com.bbringworld.ezparkapi.domain.coupon.dao.entity.Coupon;

public interface CouponProvider {

    void create(CouponRegistry registry);

    void delete(Long id);

    Integer use(String code);

    void checkExpiryDate(Coupon coupon);

    void checkIssuedDate(Coupon coupon);

}
