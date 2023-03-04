package com.bbringworld.ezparkapi.domain.membership.api;

import com.bbringworld.ezparkapi.domain.membership.adaptor.in.MembershipCheck;
import com.bbringworld.ezparkapi.domain.membership.adaptor.in.MembershipUpdate;
import com.bbringworld.ezparkapi.domain.membership.adaptor.out.MembershipInfo;
import com.bbringworld.ezparkapi.domain.membership.application.service.MembershipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/membership")
public class MembershipController {

    private final MembershipService service;

    @GetMapping("/{id}")
    public ResponseEntity<MembershipInfo> search(@Valid @PathVariable ("id") long id) {
        return ResponseEntity.ok(MembershipInfo.builder().build());
    }

    @PostMapping
    public ResponseEntity<Boolean> checkIn(@Valid @RequestBody MembershipCheck request) {
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> leave(@Valid @RequestBody MembershipCheck request) {
        return ResponseEntity.ok(true);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MembershipInfo> update(@Valid @PathVariable ("id") long id,
                                                 @RequestBody MembershipUpdate request) {
        return ResponseEntity.ok(MembershipInfo.builder().build());
    }
}
