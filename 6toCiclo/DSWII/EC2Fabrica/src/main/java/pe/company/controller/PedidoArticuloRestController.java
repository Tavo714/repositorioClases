package pe.company.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.company.model.*;
import pe.company.service.*;

@RestController
@RequestMapping("/pedido_articulo")
public class PedidoArticuloRestController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private PedidoArticuloService pedidoArticuloService;

    // Listar artículos de un pedido
    @GetMapping("/listar/{num_pedido}")
    public ResponseEntity<?> listar(@PathVariable Integer num_pedido) {
        Pedido pedidoDb = pedidoService.findById(num_pedido);
		
        if (pedidoDb != null) {
            Collection<PedidoArticulo> itemsPedidoArticulo = pedidoArticuloService.findByPedidoId(num_pedido);
            return new ResponseEntity<>(itemsPedidoArticulo, HttpStatus.OK);
        }
		
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Agregar un artículo a un pedido con cantidad
    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody PedidoArticulo pedidoArticulo) {
        Pedido pedidoDb = pedidoService.findById(pedidoArticulo.getPedido().getId());
        Articulo articuloDb = articuloService.findById(pedidoArticulo.getArticulo().getId());
		
        if (pedidoDb != null && articuloDb != null) {
            pedidoArticuloService.insert(pedidoArticulo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
		
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
