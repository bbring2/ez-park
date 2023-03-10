package com.bbringworld.ezparkapi.global.config.security;

import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.admin.exception.AdminNotFoundException;
import com.bbringworld.ezparkapi.domain.auth.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberDetailService implements UserDetailsService {

    private final AdminService adminService;

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

    public CustomUserDetails processLogin(Optional<Admin> admin) throws UsernameNotFoundException {
        if (!admin.isPresent()) {
            throw new AdminNotFoundException("Cannot find the info of an admin!");
        }

        if (!admin.get().isStatus()) {
            throw new UnauthorizedException();
        }

        return CustomUserDetails.create(admin.get());
    }
}
