package pe.company.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.company.model.*;
import pe.company.service.*;

@RestController
@RequestMapping("/fabrica_articulo")
public class FabricaArticuloRestController {
	
    @Autowired
    private FabricaService fabricaService;

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private FabricaArticuloService fabricaArticuloService;

    // Listar artículos de una fábrica
    @GetMapping("/listar/{num_fabrica}")
    public ResponseEntity<?> listar(@PathVariable Integer num_fabrica) {
        Fabrica fabricaDb = fabricaService.findById(num_fabrica);
		
        if (fabricaDb != null) {
            Collection<FabricaArticulo> itemsFabricaArticulo = fabricaArticuloService.findByFabricaId(num_fabrica);
            return new ResponseEntity<>(itemsFabricaArticulo, HttpStatus.OK);
        }
		
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Agregar un artículo a una fábrica con existencias
    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody FabricaArticulo fabricaArticulo) {
        Fabrica fabricaDb = fabricaService.findById(fabricaArticulo.getFabrica().getId());
        Articulo articuloDb = articuloService.findById(fabricaArticulo.getArticulo().getId());
		
        if (fabricaDb != null && articuloDb != null) {
            fabricaArticuloService.insert(fabricaArticulo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
		
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
