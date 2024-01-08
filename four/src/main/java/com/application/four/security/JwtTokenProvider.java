package com.application.four.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    public  String generateToken(Authentication authentication) {
        String email = authentication.getName();
        Date currentTime = new Date();
        Date expireDate = new Date(currentTime.getTime()+3600000);

        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(currentTime)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, "JWTSecretKey")
                .compact();

        return token;
    }

    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey("JWTSecretKey").parseClaimsJws(token).getBody();

        return claims.getSubject();
    }
}
