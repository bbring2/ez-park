package com.bbringworld.ezparkapi.domain.membership.application.provider;

import com.bbringworld.ezparkapi.domain.membership.adaptor.in.MemberRegistry;
import com.bbringworld.ezparkapi.domain.membership.adaptor.out.MembershipInfo;
import com.bbringworld.ezparkapi.domain.membership.dao.entity.Membership;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface MembershipProvider {

    void register(MemberRegistry registry);

    MembershipInfo update(Long id);

    MembershipInfo search(Long id);

    void cancel(Long id);

    Page<MembershipInfo> fetch(PageRequest pageRequest);
}
