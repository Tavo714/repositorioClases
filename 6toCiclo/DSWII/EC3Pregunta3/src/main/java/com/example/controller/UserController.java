package com.example.controller;

import com.example.dto.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;

@RestController
@RequestMapping("/auth")
public class UserController {

    // Clave segura de al menos 256 bits (32 caracteres en Base64)
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(
            Base64.getEncoder().encodeToString("unaClaveMuyLargaParaJWTCon256Bits!".getBytes(StandardCharsets.UTF_8)).getBytes()
    );

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();

        // Simulación de autenticación (sin base de datos)
        if ("gustavovalera".equals(user.getUsername()) && "77778888".equals(user.getPassword())) {
            String token = Jwts.builder()
                    .setSubject(user.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Expira en 24 horas
                    .signWith(SECRET_KEY, SignatureAlgorithm.HS256) // Clave segura
                    .compact();

            response.put("token", token);
        } else {
            response.put("error", "Credenciales incorrectas");
        }

        return response;
    }
}

