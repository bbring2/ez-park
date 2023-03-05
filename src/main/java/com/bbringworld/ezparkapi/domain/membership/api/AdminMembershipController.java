package com.bbringworld.ezparkapi.domain.membership.api;

import com.bbringworld.ezparkapi.domain.membership.adaptor.in.MembershipSearch;
import com.bbringworld.ezparkapi.domain.membership.adaptor.out.MembershipInfo;
import com.bbringworld.ezparkapi.domain.membership.application.service.MembershipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/membership")
public class AdminMembershipController {

    private final MembershipService service;

    @GetMapping
    public ResponseEntity<List<MembershipInfo>> fetch() {
        return ResponseEntity.ok(List.of(MembershipInfo.builder().build()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipInfo> search(@Valid @PathVariable ("id") long id,
                                                 @ModelAttribute MembershipSearch condition) {
        return ResponseEntity.ok(MembershipInfo.builder().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@Valid @PathVariable ("id") long id) {
        return ResponseEntity.ok(true);
    }

}
