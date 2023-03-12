package com.bbringworld.ezparkapi.domain.review.dao.repository.support;

import com.bbringworld.ezparkapi.domain.review.dao.repository.ReviewImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewImageRepositorySupport {

    private final ReviewImageRepository repository;

}
