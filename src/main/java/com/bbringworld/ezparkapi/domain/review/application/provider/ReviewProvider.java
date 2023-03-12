package com.bbringworld.ezparkapi.domain.review.application.provider;

import com.bbringworld.ezparkapi.domain.review.adaptor.in.ReviewRegistry;

public interface ReviewProvider {

    void register(ReviewRegistry registry);

    void delete(Long id);

}