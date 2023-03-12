package com.bbringworld.ezparkapi.global.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.bbringworld.ezparkapi.domain.auth.exception.TokenException;
import com.bbringworld.ezparkapi.global.domain.adaptor.in.TokenFormat;
import com.bbringworld.ezparkapi.global.util.Aes256;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Component
public class JwtProvider {

    @Value("${biz.jwt.issuer}")
    private String issuer;

    @Value("${biz.jwt.secret}")
    private String secret;

    @Value("${biz.jwt.header}")
    private String header;

    private Gson gson = new Gson();

    public String generate(TokenFormat format, int expiredMinutes) {
        long begin = Instant.now().toEpochMilli();
        long end = Instant.now().plus(expiredMinutes, ChronoUnit.MINUTES).toEpochMilli();

        Date iat = new Date(begin);
        Date exp = new Date(end);

        String claim;

        try {
            claim = gson.toJson(format);
        } catch (Exception e) {
            throw new TokenException("There is an error during generating access token.");
        }

        String encClaim = Aes256.encrypt(claim, secret);

        return JWT.create()
                .withIssuer(issuer)
                .withIssuedAt(iat)
                .withExpiresAt(exp)
                .withClaim("u", encClaim)
                .sign(Algorithm.HMAC256(secret));
    }

    public String extract(String[] decClaim, int index, String key) {
        return Optional.ofNullable(decClaim)
                .map(it -> it[index])
                .orElseThrow(() -> new TokenException("There is an error during extracting token info."));
    }

    public TokenFormat getTokenInfo(String encToken) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secret)).build();

        Claim jwt = verifier.verify(encToken).getClaim("u");
        String decClaim = Aes256.decrypt(jwt.asString(), secret);

        return gson.fromJson(decClaim, TokenFormat.class);
    }

    public boolean validate(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secret)).build();
            verifier.verify(token);

            return true;
        } catch (SignatureVerificationException e) {
            log.error(e.getMessage());
            throw new TokenException("Failed to verify token.");
        }
    }

    public String getFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(header);

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }


}