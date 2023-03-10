package com.bbringworld.ezparkapi.global.config.security;

import com.bbringworld.ezparkapi.domain.admin.dao.entity.Admin;
import com.bbringworld.ezparkapi.domain.auth.exception.AuthenticationException;
import com.bbringworld.ezparkapi.domain.code.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private Long id;

    @JsonIgnore
    private String nickname;

    @JsonIgnore
    private String password;

    private String firstName;

    private String lastName;

    private Collection<? extends GrantedAuthority> authorities;

    public static CustomUserDetails create(Admin admin) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (Objects.isNull(admin)) throw new AuthenticationException("Failed to authenticate!");

        //디폴트로 ROLE_USER 권한을 부여한다.
        authorities.add( new SimpleGrantedAuthority("ROLE_ADMIN"));

        //인증 회원 권한 부여
        if (Role.SUPER_ADMIN.equals(admin.getRole())) {
            authorities.add( new SimpleGrantedAuthority("ROLE_SUPER_ADMIN"));
        }

        return CustomUserDetails.builder()
                .id(admin.getId())
                .nickname(admin.getNickname())
                .password(admin.getPassword())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .authorities(authorities)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nickname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUserDetails that = (CustomUserDetails) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
