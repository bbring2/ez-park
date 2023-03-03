package com.bbringworld.ezparkapi.domain.spot.api;

import com.bbringworld.ezparkapi.domain.spot.adaptor.in.SpotRegistry;
import com.bbringworld.ezparkapi.domain.spot.adaptor.in.SpotUpdate;
import com.bbringworld.ezparkapi.domain.spot.adaptor.out.SpotInfo;
import com.bbringworld.ezparkapi.domain.spot.application.service.SpotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/spot")
@PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
public class AdminSpotController {

    private final SpotService service;

    @GetMapping("/{id}")
    public ResponseEntity<SpotInfo> search(@Valid @PathVariable ("id") long id) {
        return ResponseEntity.ok(service.search(id));
    }

    @GetMapping
    public ResponseEntity<List<SpotInfo>> fetch() {
        return ResponseEntity.ok(service.fetch());
    }

    @PostMapping
    public ResponseEntity<Void> register(@Valid @RequestBody SpotRegistry request) {
        service.register(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SpotInfo> update(@Valid @PathVariable ("id") long id,
                                            @RequestBody SpotUpdate request) {
        return ResponseEntity.ok(service.update(id, request));
    }
}
