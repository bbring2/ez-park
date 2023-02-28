package com.bbringworld.ezparkapi.domain.admin.adaptor.in;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Builder
public record AdminRegistry (
        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @NotBlank
        String nickname,

        @NotBlank
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!~$%^&-+=()])(?=\\S+$).{8,16}$")
        String password,

        @NotBlank
        String mobile
) {

    public static Admin toEntity(AdminRegistry in, PasswordEncoder passwordEncoder) {
        return Admin.builder()
                .firstName(in.firstName)
                .lastName(in.lastName)
                .nickname(in.nickname)
                .password(passwordEncoder.encode(in.password))
                .mobile(in.mobile)
                .build();
    }

}
