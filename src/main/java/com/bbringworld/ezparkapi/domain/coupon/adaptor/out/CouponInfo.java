package com.bbringworld.ezparkapi.domain.coupon.adaptor.out;

import com.bbringworld.ezparkapi.domain.coupon.dao.entity.Coupon;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record CouponInfo(
        long id,
        String code,
        Integer rate,
        LocalDate issuedDate,
        LocalDate expiredDate,
        boolean status,
        String createdBy,
        LocalDateTime createdAt,
        String updatedBy,
        LocalDateTime updatedAt
) {

    public static CouponInfo of(Coupon coupon) {
        return CouponInfo.builder()
                .id(coupon.getId())
                .code(coupon.getCode())
                .rate(coupon.getRate())
                .issuedDate(coupon.getIssuedDate())
                .expiredDate(coupon.getExpiredDate())
                .status(coupon.isStatus())
                .createdBy(coupon.getCreatedBy())
                .createdAt(coupon.getCreatedAt())
                .updatedBy(coupon.getUpdatedBy())
                .updatedAt(coupon.getUpdatedAt())
                .build();
    }
}
