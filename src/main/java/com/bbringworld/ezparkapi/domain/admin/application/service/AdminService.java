package com.bbringworld.ezparkapi.domain.admin.application.service;

import com.bbringworld.ezparkapi.domain.admin.adaptor.in.AdminUpdate;
import com.bbringworld.ezparkapi.domain.admin.adaptor.out.AdminInfo;
import com.bbringworld.ezparkapi.domain.admin.application.provider.AdminProvider;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.QAdmin;
import com.bbringworld.ezparkapi.domain.admin.dao.repository.AdminRepository;
import com.bbringworld.ezparkapi.domain.admin.exception.AdminNotFoundException;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService implements AdminProvider {

    private final JPAQueryFactory queryFactory;
    private final AdminRepository repository;

    @Override
    public boolean existAdminByNickname(String nickname) {
        return repository.existsByNicknameAndStatusFalse(nickname);
    }

    @Override
    public Optional<Admin> findAdminByNickname(String nickname) {
        return repository.findByNickname(nickname);
    }

    @Override
    public Admin findAdminById(long id) {
        return repository.findById(id)
                .orElseThrow(AdminNotFoundException::new);
    }

    @Override
    public boolean existAdminByMobile(String mobile, boolean verified) {
        return false;
    }

    @Override
    public void updateAdminProfile(long id, AdminUpdate update) {
    }

    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    public List<AdminInfo> of(List<Admin> adminEntityList) {
        return adminEntityList
                .stream()
                .map(AdminInfo::of)
                .collect(Collectors.toList());
    }

    public List<Admin> findValidAdmin() {
        QAdmin admin = QAdmin.admin;
        return queryFactory
                .selectFrom(admin)
                .where(admin.status.eq(true))
                .fetch();
    }

}
