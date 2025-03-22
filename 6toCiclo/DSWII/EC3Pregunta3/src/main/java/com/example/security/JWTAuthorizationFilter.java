package com.example.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import javax.crypto.SecretKey;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JWTAuthorizationFilter.class);

    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(
            Base64.getEncoder().encodeToString("unaClaveMuyLargaParaJWTCon256Bits!".getBytes(StandardCharsets.UTF_8)).getBytes()
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        logger.info("🛡️ Filtro de autorización ejecutándose para: {}", request.getRequestURI());

        String token = request.getHeader("Authorization");
        logger.info("🔑 Header Authorization recibido: {}", token);

        if (token == null || !token.startsWith("Bearer ")) {
            logger.warn("⚠️ Token no presente o mal formado, pasando la petición...");
            chain.doFilter(request, response);
            return;
        }

        token = token.replace("Bearer ", "");
        logger.info("✅ Token limpio: {}", token);

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String username = claims.getSubject();
            logger.info("🔓 Token válido. Usuario autenticado: {}", username);

            if (username != null) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                logger.info("✅ Usuario autenticado correctamente: {}", username);
            }
        } catch (Exception e) {
            logger.error("❌ Error al validar el token: ", e);
            SecurityContextHolder.clearContext();
        }

        chain.doFilter(request, response);
    }
}

