package com.bbringworld.ezparkapi.domain.payment.dao.entity;

import com.bbringworld.ezparkapi.global.domain.dao.Registration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@AllArgsConstructor
@Table(name = "payment_log")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "is_membership")
    private boolean isMembership;

    @Column
    private boolean discounted;

    @Column(name = "origin_amount")
    private String originAmount;

    @Column(name = "total_amount")
    private String totalAmount;

    @Column(name = "card_digit")
    private String cardDigit;

    @Column(name = "card_cmpny")
    private String cardCmpny;

    @Column
    private String status;

}
