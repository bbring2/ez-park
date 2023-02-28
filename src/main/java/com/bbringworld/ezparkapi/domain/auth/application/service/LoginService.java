package com.bbringworld.ezparkapi.domain.auth.application.service;

import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final AdminService service;

}
