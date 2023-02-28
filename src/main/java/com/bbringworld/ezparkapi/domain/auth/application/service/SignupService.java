package com.bbringworld.ezparkapi.domain.auth.application.service;

import com.bbringworld.ezparkapi.domain.admin.adaptor.in.AdminRegistry;
import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.auth.application.provider.AuthProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignupService {

    private final AuthProvider provider;

    private final AdminService adminService;

    private final PasswordEncoder passwordEncoder;

    public void signUpAsAdmin(AdminRegistry registry) {
        Admin admin = AdminRegistry.toEntity(registry, passwordEncoder);

        adminService.existAdminByNickname(admin.getNickname());

        adminService.save(admin);
    }

}
