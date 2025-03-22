package com.example.controller;

import com.example.payload.AuthenticationLogin;
import com.example.payload.AuthenticationRegister;
import com.example.payload.AuthenticationResponse;
import com.example.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRegister request) {
        System.out.println("Datos recibidos en el registro: " + request);
        return ResponseEntity.ok(authenticationService.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationLogin request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
