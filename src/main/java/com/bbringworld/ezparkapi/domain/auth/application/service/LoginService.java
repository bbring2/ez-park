package com.bbringworld.ezparkapi.domain.auth.application.service;

import com.bbringworld.ezparkapi.domain.admin.adaptor.out.AdminInfo;
import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import com.bbringworld.ezparkapi.domain.auth.adaptor.in.LoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final AdminService service;

    public AdminInfo login(LoginForm form) {
        return AdminInfo.builder().build();
    }
}
