package com.example.security.service;

import com.example.entity.Cliente;
import com.example.payload.AuthenticationLogin;
import com.example.payload.AuthenticationRegister;
import com.example.payload.AuthenticationResponse;
import com.example.repository.ClienteRepository;
import com.example.security.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(AuthenticationRegister request) {
        Cliente cliente = new Cliente();
        cliente.setDnicliente(request.getDnicliente());
        cliente.setNombre(request.getNombre());
        cliente.setApellidos(request.getApellidos());
        cliente.setDomicilio(request.getDomicilio());
        cliente.setFechaNacimiento(request.getFechaNacimiento());
        cliente.setClave(passwordEncoder.encode(request.getClave()));
        cliente.setFechaRegistro(LocalDate.now());
        cliente.setEstado(true);

        clienteRepository.save(cliente);

        String token = jwtUtils.generateToken(cliente.getDnicliente());
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(AuthenticationLogin request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getDnicliente(),
                        request.getClave()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getDnicliente());
        String token = jwtUtils.generateToken(userDetails.getUsername());

        return new AuthenticationResponse(token);
    }
}
