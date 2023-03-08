package com.bbringworld.ezparkapi.domain.review.dao.repository;

import com.bbringworld.ezparkapi.domain.review.dao.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
