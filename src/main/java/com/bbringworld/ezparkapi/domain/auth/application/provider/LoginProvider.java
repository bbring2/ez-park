package com.bbringworld.ezparkapi.domain.auth.application.provider;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.auth.adaptor.in.LoginForm;
import com.bbringworld.ezparkapi.domain.auth.adaptor.out.TokenInfo;

public interface LoginProvider {
    TokenInfo login(LoginForm form);

    TokenInfo makeToken(Admin admin);

}
