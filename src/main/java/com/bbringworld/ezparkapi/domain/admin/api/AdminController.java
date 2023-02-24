package com.bbringworld.ezparkapi.domain.admin.api;

import com.bbringworld.ezparkapi.domain.admin.adaptor.in.AdminUpdate;
import com.bbringworld.ezparkapi.domain.admin.adaptor.out.AdminInfo;
import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/admin")
public class AdminController {

    private final AdminService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AdminInfo> search(@Valid  @PathVariable ("id") Long id) {
        return ResponseEntity.ok(new AdminInfo());
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<AdminInfo> update(@Valid @PathVariable ("id") Long id, @RequestBody AdminUpdate request) {
        return ResponseEntity.ok(new AdminInfo());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@Valid @PathVariable ("id") Long id) {
        return ResponseEntity.ok(true);
    }

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @GetMapping(value = "/list-up")
    public ResponseEntity<List<AdminInfo>> fetch() {
        return ResponseEntity.ok(List.of(new AdminInfo()));
    }

}
