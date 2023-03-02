package com.bbringworld.ezparkapi.domain.membership.application.service;

import com.bbringworld.ezparkapi.domain.membership.adaptor.in.MemberRegistry;
import com.bbringworld.ezparkapi.domain.membership.adaptor.out.MembershipInfo;
import com.bbringworld.ezparkapi.domain.membership.application.provider.MembershipProvider;
import com.bbringworld.ezparkapi.domain.membership.dao.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class MembershipService implements MembershipProvider {

    private final MembershipRepository repository;


    @Override
    public void register(MemberRegistry registry) {

    }

    @Override
    public MembershipInfo update(Long id) {
        return null;
    }

    @Override
    public MembershipInfo search(Long id) {
        return null;
    }

    @Override
    public void cancel(Long id) {

    }

    @Override
    public Page<MembershipInfo> fetch(PageRequest pageRequest) {
        return null;
    }
}
