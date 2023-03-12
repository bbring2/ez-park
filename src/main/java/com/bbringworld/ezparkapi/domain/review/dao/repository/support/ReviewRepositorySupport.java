package com.bbringworld.ezparkapi.domain.review.dao.repository.support;

import com.bbringworld.ezparkapi.domain.review.dao.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositorySupport {

    private final ReviewRepository repository;
}
