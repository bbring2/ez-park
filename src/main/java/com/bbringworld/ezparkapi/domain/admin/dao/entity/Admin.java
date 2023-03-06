package com.bbringworld.ezparkapi.domain.admin.dao.entity;

import com.bbringworld.ezparkapi.domain.code.Role;
import com.bbringworld.ezparkapi.global.domain.dao.Registration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@Table(name = "admin")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin extends Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String nickname;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private String password;

    @Column
    private String mobile;

    @Column(name = "mobile_code")
    private String mobileCode;

    @Column(name = "mobile_verified", columnDefinition = "TINYINT(1)")
    private boolean mobileVerified;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean status;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    public boolean checkMobileCode(String code) {
        return code.equals(mobileCode);
    }

}
