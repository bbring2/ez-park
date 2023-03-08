package com.bbringworld.ezparkapi.domain.review.application.service;

import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.review.adaptor.in.ReviewListRegistry;
import com.bbringworld.ezparkapi.domain.review.application.provider.ReviewProvider;
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
public class ReviewListService implements ReviewProvider {

    private final ReviewListRepository repository;

    private final AdminService adminService;

    public ReviewList getById(long id) {
        return repository.findById(id)
                .orElseThrow(ReviewListNotFoundException::new);
    }

    public ReviewList save(ReviewList reviewList) {
        return repository.save(reviewList);
    }

    @Override
    public void register() {
    }

    public ReviewList register(ReviewListRegistry registry) {
        Admin admin = adminService.getById(registry.adminId());

        admin.checkAdmin();

        ReviewList list = ReviewListRegistry.toEntity(registry);

        return save(list);
    }

    @Override
    public void delete(Long id) {

    }

}
