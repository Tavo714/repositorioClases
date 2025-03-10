package pe.company.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.company.model.Cliente;
import pe.company.model.Pedido;
import pe.company.service.ClienteService;
import pe.company.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoRestController {

    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        Collection<Pedido> itemsPedido = pedidoService.findAll();
        return new ResponseEntity<>(itemsPedido, HttpStatus.OK);
    }

    @GetMapping("/buscar/{num_pedido}")
    public ResponseEntity<?> buscar(@PathVariable Integer num_pedido) {
        Pedido pedidoDb = pedidoService.findById(num_pedido);
        if (pedidoDb != null) {
            return new ResponseEntity<>(pedidoDb, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Pedido pedido) {
        // Verifica que el cliente enviado existe en la BD
        Cliente clienteDb = clienteService.findById(pedido.getCliente().getId());

        if (clienteDb == null) {
            return new ResponseEntity<>("El cliente no existe", HttpStatus.NOT_FOUND);
        }

        // Asigna el cliente existente al pedido
        pedido.setCliente(clienteDb);

        // Guarda el pedido
        pedidoService.insert(pedido);

        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{num_pedido}")
    public ResponseEntity<?> editar(@PathVariable Integer num_pedido, @RequestBody Pedido newPedido) {
        Pedido pedidoDb = pedidoService.findById(num_pedido);
        if (pedidoDb != null) {
            pedidoDb.setDireccionEnvio(newPedido.getDireccionEnvio());
            pedidoDb.setFechaPedido(newPedido.getFechaPedido());
            pedidoService.update(pedidoDb);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{num_pedido}")
    public ResponseEntity<?> borrar(@PathVariable Integer num_pedido) {
        Pedido pedidoDb = pedidoService.findById(num_pedido);
        if (pedidoDb != null) {
            pedidoService.delete(num_pedido);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

