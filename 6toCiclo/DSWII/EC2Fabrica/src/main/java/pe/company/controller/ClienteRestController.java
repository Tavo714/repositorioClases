package pe.company.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.company.model.Cliente;
import pe.company.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        Collection<Cliente> itemsCliente = clienteService.findAll();
        return new ResponseEntity<>(itemsCliente, HttpStatus.OK);
    }

    @GetMapping("/buscar/{num_cliente}")
    public ResponseEntity<?> buscar(@PathVariable Integer num_cliente) {
        Cliente clienteDb = clienteService.findById(num_cliente);
        if (clienteDb != null) {
            return new ResponseEntity<>(clienteDb, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Cliente cliente) {
        clienteService.insert(cliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editar/{num_cliente}")
    public ResponseEntity<?> editar(@PathVariable Integer num_cliente, @RequestBody Cliente newCliente) {
        Cliente clienteDb = clienteService.findById(num_cliente);
        if (clienteDb != null) {
            clienteDb.setNombre(newCliente.getNombre());
            clienteDb.setDireccion1(newCliente.getDireccion1());
            clienteDb.setDireccion2(newCliente.getDireccion2());
            clienteDb.setDireccion3(newCliente.getDireccion3());
            clienteDb.setSaldo(newCliente.getSaldo());
            clienteDb.setLimiteCredito(newCliente.getLimiteCredito());
            clienteService.update(clienteDb);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{num_cliente}")
    public ResponseEntity<?> borrar(@PathVariable Integer num_cliente) {
        Cliente clienteDb = clienteService.findById(num_cliente);
        if (clienteDb != null) {
            clienteService.delete(num_cliente);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

