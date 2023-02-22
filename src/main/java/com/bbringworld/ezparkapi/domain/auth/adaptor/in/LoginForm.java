package com.bbringworld.ezparkapi.domain.auth.adaptor.in;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class LoginForm {

    @NotEmpty
    private String nickname;

    @NotEmpty
    private String password;

}
