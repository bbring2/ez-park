package com.bbringworld.ezparkapi.domain.review.application.service;

import com.bbringworld.ezparkapi.domain.review.adaptor.in.ReviewRegistry;
import com.bbringworld.ezparkapi.domain.review.application.provider.ReviewProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService implements ReviewProvider {
    @Override
    public void register(ReviewRegistry registry) {

    }

    @Override
    public void delete(Long id) {

    }
}
