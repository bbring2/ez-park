package com.bbringworld.ezparkapi.domain.review.api;

import com.bbringworld.ezparkapi.domain.review.application.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest/review")
public class ReviewController {

    private final ReviewService service;
}
