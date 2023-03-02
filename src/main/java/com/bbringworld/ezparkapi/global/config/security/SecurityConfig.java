package com.bbringworld.ezparkapi.global.config.security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] WHITE_LIST = {"/hello/**", "/guest/**", "/auth/**", "/images/**"};

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf().disable()
            .cors().disable()
            .authorizeHttpRequests(request -> request
                    .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                    .requestMatchers(WHITE_LIST).permitAll()
                    .anyRequest().authenticated()
            );

        return httpSecurity.build();
    }
}
