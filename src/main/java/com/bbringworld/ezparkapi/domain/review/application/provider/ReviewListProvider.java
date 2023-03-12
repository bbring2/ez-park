package com.bbringworld.ezparkapi.domain.review.application.provider;

import com.bbringworld.ezparkapi.domain.review.adaptor.in.ReviewListRegistry;
import com.bbringworld.ezparkapi.domain.review.adaptor.in.ReviewListUpdate;
import com.bbringworld.ezparkapi.domain.review.adaptor.out.ReviewListInfo;

public interface ReviewListProvider {

    void register(ReviewListRegistry registry);

    void delete(long id);

    ReviewListInfo update(long id, ReviewListUpdate update);

}
