package com.bbringworld.ezparkapi.domain.membership.dao.entity;

import com.bbringworld.ezparkapi.domain.code.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "membership")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nickname;

    @Column(name = "car_number")
    private String carNumber;

    @Column
    private String mobile;

    @Column
    private String hash;

    @Column(name = "mobile_verified", columnDefinition = "TINYINT(1)")
    private boolean mobileVerified;

    @Column(name = "mobile_code")
    private String mobileCode;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "card_number")
    private String cardNumber;

    @Column
    private String bod;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean status;
}