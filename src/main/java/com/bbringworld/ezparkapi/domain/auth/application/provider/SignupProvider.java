package com.bbringworld.ezparkapi.domain.auth.application.provider;

import com.bbringworld.ezparkapi.domain.auth.adaptor.out.TokenInfo;

public interface SignupProvider {

    TokenInfo signup();
}
