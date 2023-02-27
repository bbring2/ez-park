package com.bbringworld.ezparkapi.domain.coupon.adaptor.in;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.coupon.dao.entity.Coupon;
import com.bbringworld.ezparkapi.global.util.StringUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString
public class CouponRegistry {

    private final long adminId;

    private final String rate;

    private final LocalDate issuedDate;

    private final LocalDate expiredDate;

    public static Coupon toEntity(Admin admin, CouponRegistry request) {
        return Coupon.builder()
//                .code(StringUtil)
                .build();
    }

}
