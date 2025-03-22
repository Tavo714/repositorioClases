package com.example.controller;

import com.example.dto.User;
import com.example.security.Constants;
import com.example.security.JWTAuthenticationConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class LoginController {

    // Usuario y contraseña quemados para efectos del examen
    private static final String USUARIO_VALIDO = "gvalera";
    private static final String PASSWORD_VALIDA = "714";

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        if (USUARIO_VALIDO.equals(user.getUsername()) && PASSWORD_VALIDA.equals(user.getPassword())) {
            String token = JWTAuthenticationConfig.getToken(user.getUsername());
            return ResponseEntity.ok("Token: " + token);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
