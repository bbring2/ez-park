package com.bbringworld.ezparkapi.domain.review.dao.repository.support;

import com.bbringworld.ezparkapi.domain.review.dao.repository.ReviewListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewListRepositorySupport {

    private final ReviewListRepository repository;

}
