package com.bbringworld.ezparkapi.domain.spot.api;

import com.bbringworld.ezparkapi.domain.spot.adaptor.out.SpotInfo;
import com.bbringworld.ezparkapi.domain.spot.application.service.SpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest/spot")
public class SpotController {

    private final SpotService service;

    @GetMapping
    public ResponseEntity<List<SpotInfo>> fetch() {
        return ResponseEntity.ok(List.of(SpotInfo.builder().build()));
    }

}
