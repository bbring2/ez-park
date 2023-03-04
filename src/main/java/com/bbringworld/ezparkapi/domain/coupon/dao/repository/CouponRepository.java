package com.bbringworld.ezparkapi.domain.coupon.dao.repository;

import com.bbringworld.ezparkapi.domain.coupon.dao.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Optional<Coupon> findByCodeAndStatusTrue(String code);

}
