package com.bbringworld.ezparkapi.domain.review.dao.repository;

import com.bbringworld.ezparkapi.domain.review.dao.entity.ReviewList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewListRepository extends JpaRepository<ReviewList, Long> {
}
