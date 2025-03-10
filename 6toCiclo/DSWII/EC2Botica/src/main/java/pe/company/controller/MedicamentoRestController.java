package pe.company.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import pe.company.model.Medicamento;
import pe.company.service.MedicamentoService;
 
@RestController
@RequestMapping("/medicamentos") // Definir la base de la ruta
public class MedicamentoRestController {
    
    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping("/listar_public")
    public ResponseEntity<?> listarPUBLIC() {
        Collection<Medicamento> itemsMedicamento = medicamentoService.findAll();
        if (itemsMedicamento.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(itemsMedicamento, HttpStatus.OK);
    }

    @GetMapping("/listar_admin")
    public ResponseEntity<?> listarADMIN() {
        Collection<Medicamento> itemsMedicamento = medicamentoService.findAll();
        if (itemsMedicamento.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(itemsMedicamento, HttpStatus.OK);
    }

    @GetMapping("/listar_user")
    public ResponseEntity<?> listarUSER() {
        Collection<Medicamento> itemsMedicamento = medicamentoService.findAll();
        if (itemsMedicamento.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(itemsMedicamento, HttpStatus.OK);
    }
}
