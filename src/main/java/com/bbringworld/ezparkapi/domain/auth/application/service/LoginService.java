package com.bbringworld.ezparkapi.domain.auth.application.service;

import com.bbringworld.ezparkapi.domain.admin.adaptor.out.AdminInfo;
import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.auth.adaptor.in.LoginForm;
import com.bbringworld.ezparkapi.domain.auth.adaptor.out.TokenInfo;
import com.bbringworld.ezparkapi.domain.auth.application.provider.LoginProvider;
import com.bbringworld.ezparkapi.global.config.security.JwtProvider;
import com.bbringworld.ezparkapi.global.config.security.TokenFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService implements LoginProvider {

    @Value("${biz.jwt.expired}")
    int jwtExpiredMinutes;

    @Value("${biz.jwt.refresh-expired}")
    int refreshJwtExpiredMinutes;

    private final AdminService service;

    private final JwtProvider jwtProvider;

    private final AuthenticationManager manager;

    @Override
    public TokenInfo login(LoginForm form) {
        Admin admin = service.getByNickname(form.nickname());

        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        form.nickname(), form.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return makeToken(admin);
    }

    @Override
    public TokenInfo makeToken(Admin admin) {
        TokenFormat tokenFormat = TokenFormat.of(admin);

        String accessToken = jwtProvider.generate(tokenFormat, jwtExpiredMinutes);
        String refreshToken = jwtProvider.generate(tokenFormat, refreshJwtExpiredMinutes);

        return TokenInfo.of(admin, accessToken, refreshToken);
    }
}
