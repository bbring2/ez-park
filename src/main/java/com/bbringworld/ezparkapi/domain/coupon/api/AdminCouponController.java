package com.bbringworld.ezparkapi.domain.coupon.api;

import com.bbringworld.ezparkapi.domain.coupon.adaptor.in.CouponRegistry;
import com.bbringworld.ezparkapi.domain.coupon.adaptor.in.CouponUpdate;
import com.bbringworld.ezparkapi.domain.coupon.adaptor.out.CouponInfo;
import com.bbringworld.ezparkapi.domain.coupon.application.serivce.CouponService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2/coupon")
public class AdminCouponController {

    private final CouponService service;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CouponRegistry request) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@Valid @PathVariable ("id") Long id) {
        return ResponseEntity.ok(true);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<CouponInfo> update(@Valid @PathVariable ("id") Long id,
                                             @RequestBody CouponUpdate request) {
        return ResponseEntity.ok(CouponInfo.builder().build());
    }

}
