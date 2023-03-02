package com.bbringworld.ezparkapi.domain.membership.adaptor.in;

import com.bbringworld.ezparkapi.domain.code.Gender;
import com.bbringworld.ezparkapi.domain.membership.dao.entity.Membership;
import com.bbringworld.ezparkapi.global.util.DateUtil;
import lombok.Builder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Builder
public record MemberRegistry (
        long spotId,
        String nickname,
        String carNumber,
        String mobile,
        boolean mobileVerified,
        String startDate,
        String endDate,
        String cardNumber,
        String bod,
        String gender
) {
    public static Membership toEntity(MemberRegistry request, PasswordEncoder passwordEncoder, String salt) {
        return Membership.builder()
                .nickname(request.nickname)
                .carNumber(request.carNumber)
                .mobile(request.mobile)
                .hash(passwordEncoder.encode(request.carNumber+request.mobile+salt))
                .mobileVerified(request.mobileVerified)
                .startDate(DateUtil.strToLd(request.startDate))
                .endDate(DateUtil.strToLd(request.endDate))
                .cardNumber(request.cardNumber)
                .bod(request.bod)
                .gender(Gender.valueOf(request.gender))
                .status(true)
                .build();
    }
}
