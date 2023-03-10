package com.bbringworld.ezparkapi.domain.coupon.dao.repository;

import com.bbringworld.ezparkapi.domain.coupon.dao.entity.Coupon;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.bbringworld.ezparkapi.domain.coupon.dao.entity.QCoupon.coupon;

@Repository
public class CouponRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    private final CouponRepository repository;

    public CouponRepositorySupport(JPAQueryFactory queryFactory, CouponRepository repository) {
        super(Coupon.class);
        this.queryFactory = queryFactory;
        this.repository = repository;
    }

    public List<Coupon> findByExpiredDate(LocalDate expiredDate) {
        return queryFactory.selectFrom(coupon)
                .where(coupon.expiredDate.eq(expiredDate)
                        .and(coupon.status.eq(true)))
                .fetch();
    }

    public List<Coupon> findByIssuedDateAndExpiredDate() {
        return queryFactory.selectFrom(coupon)
                .where(coupon.issuedDate.goe(LocalDate.now())
                        .and(coupon.expiredDate.loe(LocalDate.now()))
                        .and(coupon.status.eq(true)))
                .fetch();
    }
}
