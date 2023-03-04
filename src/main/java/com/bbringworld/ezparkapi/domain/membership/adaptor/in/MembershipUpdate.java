package com.bbringworld.ezparkapi.domain.membership.adaptor.in;

public record MembershipUpdate (
        String nickname,
        String carNumber,
        String mobile,
        String cardNumber,
        String bod,
        String gender
){
}
