package com.bbringworld.ezparkapi.domain.auth.adaptor.out;

import com.bbringworld.ezparkapi.domain.membership.dao.entity.Membership;
import lombok.Builder;

@Builder
public record MembershipHash (long id, String hash, String mobile, String carNumber) {
    public static MembershipHash of(Membership membership) {
        return MembershipHash.builder()
                .id(membership.getId())
                .hash(membership.getHash())
                .mobile(membership.getMobile())
                .carNumber(membership.getCarNumber())
                .build();
    }
}
