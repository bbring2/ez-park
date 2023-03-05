package com.bbringworld.ezparkapi.domain.guest.api;

import com.bbringworld.ezparkapi.domain.guest.application.service.GuestLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest")
public class GuestController {

    private final GuestLogService service;

}
