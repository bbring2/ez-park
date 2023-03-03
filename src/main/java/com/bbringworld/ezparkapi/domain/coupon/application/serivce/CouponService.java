package com.bbringworld.ezparkapi.domain.coupon.application.serivce;

import com.bbringworld.ezparkapi.domain.admin.application.service.AdminService;
import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.coupon.adaptor.in.CouponRegistry;
import com.bbringworld.ezparkapi.domain.coupon.application.provider.CouponProvider;
import com.bbringworld.ezparkapi.domain.coupon.dao.entity.Coupon;
import com.bbringworld.ezparkapi.domain.coupon.dao.repository.CouponRepository;
import com.bbringworld.ezparkapi.domain.coupon.exception.CouponNotFoundException;
import com.bbringworld.ezparkapi.domain.coupon.exception.ExpiredCouponException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponService implements CouponProvider {

    private final CouponRepository repository;

    private final AdminService adminService;

    public Coupon save(Coupon coupon) {
        return repository.save(coupon);
    }

    public Coupon getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CouponNotFoundException("Doesn't exist this coupon"));
    }

    public Coupon getByCode(String code) {
        return repository.findByCodeAndStatusTrue(code)
                .orElseThrow(() -> new CouponNotFoundException("Doesn't exist this coupon."));
    }

    @Override
    public void create(CouponRegistry registry) {
        Admin admin = adminService.findAdminById(registry.adminId());

        Coupon coupon = CouponRegistry.toEntity(admin, registry);

        save(coupon);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Integer use(String code) {
        Coupon coupon = getByCode(code);

        checkExpiryDate(coupon);

        return coupon.getRate();
    }

    public void checkExpiryDate(Coupon coupon) {
        if(coupon.getExpiredDate().isAfter(LocalDate.now())) {
            throw new ExpiredCouponException("This coupon has been expired");
        }
    }

    public void checkIssuedDate(Coupon coupon) {
        if(coupon.getIssuedDate().isBefore(LocalDate.now())) {
            throw new ExpiredCouponException("This coupon hasn't been issued yet");
        }
    }
}
