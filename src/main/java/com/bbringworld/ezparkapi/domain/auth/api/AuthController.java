package com.bbringworld.ezparkapi.domain.auth.api;

import com.bbringworld.ezparkapi.domain.admin.adaptor.out.AdminInfo;
import com.bbringworld.ezparkapi.domain.auth.adaptor.in.LoginForm;
import com.bbringworld.ezparkapi.domain.auth.adaptor.out.TokenInfo;
import com.bbringworld.ezparkapi.domain.auth.application.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final LoginService loginService;

    @PostMapping(value = "/in")
    public ResponseEntity<TokenInfo> login(@Valid @RequestBody LoginForm request) {
        return ResponseEntity.ok(loginService.login(request));
    }

}
