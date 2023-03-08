package com.bbringworld.ezparkapi.domain.review.application.provider;


import com.bbringworld.ezparkapi.domain.review.adaptor.in.ReviewListRegistry;
import com.bbringworld.ezparkapi.domain.review.adaptor.in.ReviewRegistry;

public interface ReviewProvider {

    void register();

    void delete(Long id);

}