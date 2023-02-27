package com.bbringworld.ezparkapi.domain.auth.application.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthProvider {

    @Value("${ezpark.auth.token-expiry}")
    private String validTime;

}
