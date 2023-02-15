package com.bbringworld.ezparkapi.domain.admin.adaptor.in;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminRegistry {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String nickname;

    @NotEmpty
    @Pattern(message = "최소 한개 이상의 대소문자와 숫자, 특수문자를 포함한 8자 이상 16자 이하의 비밀번호를 입력해야 합니다.",
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!~$%^&-+=()])(?=\\S+$).{8,16}$")
    private String password;

    @NotEmpty
    private String mobile;

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
