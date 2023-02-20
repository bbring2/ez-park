package com.bbringworld.ezparkapi.domain.admin.api;

import com.bbringworld.ezparkapi.domain.admin.adaptor.out.AdminInfo;
import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/admin")
public class AdminController {

    private final AdminService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AdminInfo> search(@Valid  @PathVariable ("id") Long id) {
        return ResponseEntity.ok(new AdminInfo());
    }

}
