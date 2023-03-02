package com.bbringworld.ezparkapi.domain.membership.adaptor.out;

import com.bbringworld.ezparkapi.domain.membership.dao.entity.Membership;
import com.bbringworld.ezparkapi.global.util.DateUtil;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record MembershipInfo (
        long id,
        String nickname,
        String carNumber,
        String mobile,
        boolean mobileVerified,
        String startDate,
        String endDate,
        String cardNumber,
        String bod,
        String gender,
        boolean status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static MembershipInfo of(Membership membership) {
        return MembershipInfo.builder()
                .id(membership.getId())
                .nickname(membership.getNickname())
                .carNumber(membership.getCarNumber())
                .mobile(membership.getMobile())
                .mobileVerified(membership.isMobileVerified())
                .startDate(DateUtil.ldToStr(membership.getStartDate()))
                .endDate(DateUtil.ldToStr(membership.getEndDate()))
                .cardNumber(membership.getCardNumber())
                .bod(membership.getBod())
                .gender(membership.getGender())
                .status(membership.isStatus())
                .createdAt(membership.getCreatedAt())
                .updatedAt(membership.getUpdatedAt())
                .build();
    }
}
