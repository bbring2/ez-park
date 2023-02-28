package com.bbringworld.ezparkapi.domain.auth.api;

import com.bbringworld.ezparkapi.domain.admin.adaptor.in.AdminRegistry;
import com.bbringworld.ezparkapi.domain.auth.application.service.LoginService;
import com.bbringworld.ezparkapi.domain.auth.application.service.SignupService;
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
public class AdminAuthController {

    private final LoginService loginService;

    private final SignupService signupService;

    @PostMapping(value = "/in")
    public ResponseEntity.BodyBuilder singup(@Valid @RequestBody AdminRegistry request) {
        signupService.signUpAsAdmin(request);
        return ResponseEntity.ok();
    }

}
