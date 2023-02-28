package com.bbringworld.ezparkapi.domain.coupon.adaptor.in;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.coupon.dao.entity.Coupon;
import com.bbringworld.ezparkapi.global.util.DateUtil;
import com.bbringworld.ezparkapi.global.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record CouponRegistry(long adminId, String rate, String issuedDate, String expiredDate) {


    public static Coupon toEntity(Admin admin, CouponRegistry request) {
        return Coupon.builder()
                .code(StringUtil.makeCode())
                .rate(Integer.parseInt(request.rate))
                .issuedDate(DateUtil.strToLdt(request.issuedDate))
                .expiredDate(DateUtil.strToLdt(request.expiredDate))
                .status(true)
                .createdBy(admin.getNickname())
                .updatedBy("")
                .build();
    }

}
