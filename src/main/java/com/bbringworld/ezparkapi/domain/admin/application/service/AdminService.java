package com.bbringworld.ezparkapi.domain.admin.application.service;

import com.bbringworld.ezparkapi.domain.admin.adaptor.in.AdminUpdate;
import com.bbringworld.ezparkapi.domain.admin.application.provider.AdminProvider;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.admin.dao.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService implements AdminProvider {

    private final AdminRepository repository;


    @Override
    public boolean existAdminByNickname(String nickname) {
        return false;
    }

    @Override
    public Optional<Admin> findAdminByNickname(String nickname) {
        return null;
    }

    @Override
    public Admin findAdminById(long id) {
        return null;
    }

    @Override
    public boolean existAdminByMobile(String mobile, boolean verified) {
        return false;
    }

    @Override
    public void updateAdminProfile(Admin admin, AdminUpdate update) {

    }
}
