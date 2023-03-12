package com.bbringworld.ezparkapi.global.config.security.filter;

import com.bbringworld.ezparkapi.domain.auth.exception.AuthenticationException;
import com.bbringworld.ezparkapi.global.config.security.CustomUserDetails;
import com.bbringworld.ezparkapi.global.config.security.JwtProvider;
import com.bbringworld.ezparkapi.global.domain.adaptor.in.TokenFormat;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    private final UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = jwtProvider.getFromRequest(request);

            if (StringUtils.hasText(token) && jwtProvider.validate(token)) {
                TokenFormat tokenFormat = jwtProvider.getTokenInfo(token);

                CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(tokenFormat.nickname());

                if(Objects.isNull(userDetails) || !userDetails.getUsername().equals(tokenFormat.nickname())) {
                    log.error("db [{}], token [{}]", userDetails.toString(), tokenFormat.nickname());
                    throw new AuthenticationException("The information doesn't match with your information!");
                }

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);

                request.setAttribute("ID", tokenFormat.id());
                request.setAttribute("USER_ID", tokenFormat.nickname());
            }
        } catch (Exception e) {
            logger.error("Could not set user authentication in security context", e);
        }

        filterChain.doFilter(request, response);
    }
}
