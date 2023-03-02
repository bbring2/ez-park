package com.bbringworld.ezparkapi.domain.coupon.api;

import com.bbringworld.ezparkapi.domain.coupon.adaptor.out.CouponInfo;
import com.bbringworld.ezparkapi.domain.coupon.application.serivce.CouponService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest/coupon")
public class CouponController {

    private final CouponService service;

    @GetMapping
    public ResponseEntity<CouponInfo> search(@Valid @RequestParam ("code") String code) {
        return ResponseEntity.ok(CouponInfo.builder().build());
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<CouponInfo> use(@Valid @PathVariable ("id") Long id) {
        return ResponseEntity.ok(CouponInfo.builder().build());
    }

}
