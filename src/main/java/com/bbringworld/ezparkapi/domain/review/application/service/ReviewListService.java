package com.bbringworld.ezparkapi.domain.review.application.service;

import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.review.adaptor.in.ReviewListRegistry;
import com.bbringworld.ezparkapi.domain.review.adaptor.in.ReviewListUpdate;
import com.bbringworld.ezparkapi.domain.review.adaptor.in.ReviewRegistry;
import com.bbringworld.ezparkapi.domain.review.adaptor.out.ReviewListInfo;
import com.bbringworld.ezparkapi.domain.review.application.provider.ReviewListProvider;
import com.bbringworld.ezparkapi.domain.review.application.provider.ReviewProvider;
import com.bbringworld.ezparkapi.domain.review.dao.entity.Review;
import com.bbringworld.ezparkapi.domain.review.dao.entity.ReviewList;
import com.bbringworld.ezparkapi.domain.review.dao.repository.ReviewListRepository;
import com.bbringworld.ezparkapi.domain.review.exception.ReviewListNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class ReviewListService implements ReviewListProvider {

    private final AdminService adminService;

    @Override
    public void register(ReviewListRegistry registry) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public ReviewListInfo update(long id, ReviewListUpdate update) {
        return null;
    }
}
