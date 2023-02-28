package com.bbringworld.ezparkapi.domain.admin.application.service;

import com.bbringworld.ezparkapi.domain.admin.adaptor.in.AdminUpdate;
import com.bbringworld.ezparkapi.domain.admin.application.provider.AdminProvider;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.admin.dao.repository.AdminRepository;
import com.bbringworld.ezparkapi.domain.admin.exception.AdminNotFoundException;
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
    public void updateAdminProfile(Admin admin, AdminUpdate update) {
    }

    public Admin save(Admin admin) {
        return repository.save(admin);
    }
}
