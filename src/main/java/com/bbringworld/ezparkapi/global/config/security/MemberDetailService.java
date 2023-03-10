package com.bbringworld.ezparkapi.global.config.security;

import com.bbringworld.ezparkapi.domain.admin.application.provider.AdminProvider;
import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MemberDetailService implements UserDetailsService {

    private final AdminService adminService;

    @Autowired
    public MemberDetailService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Optional<Admin> findOne = adminService.findByNickname(nickname);
        Admin admin = findOne.orElseThrow(() -> new UsernameNotFoundException("This admin doesn't exist!"));

        return User.builder()
                .username(admin.getNickname())
                .password(admin.getPassword())
                .roles(admin.getRole().getDisplayName())
                .build();
    }
}
