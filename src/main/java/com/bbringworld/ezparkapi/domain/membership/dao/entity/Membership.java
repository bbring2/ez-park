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
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

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

    @Column(name = "start_date", columnDefinition = "VARCHAR(45)")
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "VARCHAR(45)")
    private LocalDate endDate;

    @Column(name = "card_number")
    private String cardNumber;

    @Column
    private String bod;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean status;

    public void unsubscribe() {
        this.status = false;
    }

    public boolean checkDate() {
        return endDate.isAfter(LocalDate.now());
    }

    public boolean matchCode(String code) {
        return code.equals(mobileCode);
    }

    public String getGender() {
        return this.gender.getDisplayName();
    }

}