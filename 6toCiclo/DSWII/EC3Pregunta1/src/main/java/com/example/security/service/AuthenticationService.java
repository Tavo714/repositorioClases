package com.example.security.service;

import com.example.payload.AuthenticationLogin;
import com.example.payload.AuthenticationRegister;
import com.example.payload.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(AuthenticationRegister request);
    AuthenticationResponse authenticate(AuthenticationLogin request);
}

