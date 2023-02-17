package com.bbringworld.ezparkapi.global.config.security;

import com.bbringworld.ezparkapi.domain.admin.application.provider.AdminProvider;
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

    private final AdminProvider adminProvider;

    @Autowired
    public MemberDetailService(AdminProvider adminProvider) {
        this.adminProvider = adminProvider;
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Optional<Admin> findOne = adminProvider.findOne(nickname);
        Admin admin = findOne.orElseThrow(() -> new UsernameNotFoundException("This admin doesn't exist!"));

        return User.builder()
                .username(admin.getNickname())
                .password(admin.getPassword())
                .roles(admin.getRole().getDisplayName())
                .build();
    }
}
