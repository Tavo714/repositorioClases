package com.example.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTAuthenticationConfig {

    public static String getToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer(Constants.ISSUER_INFO)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + Constants.TOKEN_EXPIRATION_TIME))
                .signWith(Constants.getSigningKeyB64(Constants.SUPER_SECRET_KEY), SignatureAlgorithm.HS512)
                .compact();
    }
}
