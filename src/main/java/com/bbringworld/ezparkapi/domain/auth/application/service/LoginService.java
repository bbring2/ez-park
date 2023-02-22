package com.bbringworld.ezparkapi.domain.auth.application.service;

import com.bbringworld.ezparkapi.domain.admin.application.provider.AdminProvider;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.auth.application.provider.LoginProvider;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginProvider {

    private final HttpSession session;

    private final AdminProvider provider;

    private final String ADMIN_PROPERTY = "ADMIN_ID";

    @Override
    public void login(long id) {
        session.setAttribute(ADMIN_PROPERTY, id);
    }

    @Override
    public void logout() {
        session.removeAttribute(ADMIN_PROPERTY);
    }

    @Override
    public Admin getLoginAdmin() {
        Long adminId = (Long) session.getAttribute(ADMIN_PROPERTY);
        return provider.findAdminById(adminId);
    }

    @Override
    public Long getLoginAdminId() {
        return (Long) session.getAttribute(ADMIN_PROPERTY);
    }
}
