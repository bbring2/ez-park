package com.bbringworld.ezparkapi.domain.auth.application.provider;

import com.bbringworld.ezparkapi.domain.auth.adaptor.in.LoginForm;

public interface LoginProvider {
    long login(LoginForm form);

}
