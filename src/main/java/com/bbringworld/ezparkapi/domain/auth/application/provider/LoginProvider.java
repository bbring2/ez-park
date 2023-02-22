package com.bbringworld.ezparkapi.domain.auth.application.provider;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;

public interface LoginProvider {

    public void login(long id);

    public void logout();

    public Admin getLoginAdmin();

    public Long getLoginAdminId();

}
