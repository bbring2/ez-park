package com.bbringworld.ezparkapi.domain.auth.application.provider;

import com.bbringworld.ezparkapi.domain.admin.adaptor.in.AdminRegistry;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.membership.dao.entity.Membership;

public interface AuthProvider {

    void signupAsAdmin(Admin admin);

    void signupAsMembership(Membership membership);

    long login(String nickname);

}