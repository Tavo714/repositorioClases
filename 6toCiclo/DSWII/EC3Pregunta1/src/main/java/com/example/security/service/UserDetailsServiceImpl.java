package com.example.security.service;

import com.example.entity.Cliente;
import com.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String dnicliente) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findById(dnicliente)
                .orElseThrow(() -> new UsernameNotFoundException("Cliente no encontrado con DNI: " + dnicliente));

        return new User(
                cliente.getDnicliente(),
                cliente.getClave(),
                Collections.emptyList() // Sin roles por ahora
        );
    }
}
