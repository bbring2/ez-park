package com.bbringworld.ezparkapi.domain.coupon.dao.entity;

import com.bbringworld.ezparkapi.global.domain.dao.Registration;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@Entity
@AllArgsConstructor
@Table(name = "coupon")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon extends Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String code;

    @Column
    private Integer rate;

    @Column(name = "issued_date", columnDefinition = "VARCHAR(20)")
    private LocalDate issuedDate;

    @Column(name = "expired_date", columnDefinition = "VARCHAR(20)")
    private LocalDate expiredDate;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean status;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    public void expireCoupon() {
        this.status = false;
    }

    public boolean validCoupon(String code) {
        return code.equals(this.code);
    }

    public boolean checkExpired() {
        return !expiredDate.isAfter(LocalDate.now());
    }

}
