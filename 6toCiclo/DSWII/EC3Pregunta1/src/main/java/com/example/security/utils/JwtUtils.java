package com.example.security.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtils {

    // Clave secreta en Base64 (debe ser al menos de 256 bits)
    private static final String SECRET_KEY_BASE64 = "Y2xhdmUtc2VjcmV0YS1zdXBlci1sYXJnYS1wYXJhLWp3dC1kZS1hbC1tZW5vcy0zMi1jYXJhY3RlcmVz"; 

    // Duración del token (24 horas)
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    // Obtener clave de firma en formato Base64
    private Key getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY_BASE64);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Generar token
    public String generateToken(String dnicliente) {
        return Jwts.builder()
                .setSubject(dnicliente)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Validar token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    // Extraer DNI desde el token
    public String extractDni(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}

