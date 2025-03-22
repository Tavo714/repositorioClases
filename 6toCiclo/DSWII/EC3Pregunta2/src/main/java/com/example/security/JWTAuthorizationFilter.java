package com.example.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
    	
        String header = request.getHeader(Constants.HEADER_AUTHORIZACION_KEY);

        if (header == null || !header.startsWith(Constants.TOKEN_BEARER_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.replace(Constants.TOKEN_BEARER_PREFIX, "");


        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Constants.getSigningKeyB64(Constants.SUPER_SECRET_KEY))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String username = claims.getSubject();

            if (username != null) {
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        Collections.emptyList() // No roles definidos
                );
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
                System.out.println("✅ Autenticación establecida en SecurityContext");
            }
        } catch (Exception e) {
            // Token inválido o expirado
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
}
