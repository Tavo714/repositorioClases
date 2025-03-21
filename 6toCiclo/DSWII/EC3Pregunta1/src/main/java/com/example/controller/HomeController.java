package com.example.controller;

import com.example.entity.Cliente;
import com.example.entity.Prestamo;
import com.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class HomeController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Ruta pública
    @GetMapping("/public")
    public String homePublic() {
        return "Bienvenidos a la Financiera Chihuán (Sí, sí! como la congresista a la que no le alcanzaba con S/15000 para vivir!). \nAquí te otorgamos préstamos a los más bajos intereses! (como los valores de nuestro congreso desde que tengo uso de razón)";
    }

    // Ruta protegida que requiere token JWT
    @GetMapping("/prestamo/validar")
    public ResponseEntity<String> validarPrestamo(Authentication authentication) {
        String dnicliente = authentication.getName(); // DNI viene del token

        Cliente cliente = clienteRepository.findById(dnicliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if (cliente.getPrestamos() == null || cliente.getPrestamos().isEmpty()) {
            return ResponseEntity.badRequest().body("El cliente no tiene préstamos registrados.");
        }

        Prestamo prestamo = cliente.getPrestamos().get(0); // Solo muestra el primero

        String mensaje = String.format(
                "¡¡¡Cliente %s, su préstamo de %.2f ha sido validado y aceptado con éxito, " +
                "puede acercarse a la Financiera a recoger su dinero, se recomienda tomar las previsiones del caso de seguridad!!!",
                cliente.getNombre(),
                prestamo.getImporte()
        );

        return ResponseEntity.ok(mensaje);
    }
}
