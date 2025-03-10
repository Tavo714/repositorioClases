package pe.company.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.company.model.Articulo;
import pe.company.service.ArticuloService;

@RestController
@RequestMapping("/articulo")
public class ArticuloRestController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        Collection<Articulo> itemsArticulo = articuloService.findAll();
        return new ResponseEntity<>(itemsArticulo, HttpStatus.OK);
    }

    @GetMapping("/buscar/{num_articulo}")
    public ResponseEntity<?> buscar(@PathVariable Integer num_articulo) {
        Articulo articuloDb = articuloService.findById(num_articulo);
        if (articuloDb != null) {
            return new ResponseEntity<>(articuloDb, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Articulo articulo) {
        articuloService.insert(articulo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editar/{num_articulo}")
    public ResponseEntity<?> editar(@PathVariable Integer num_articulo, @RequestBody Articulo newArticulo) {
        Articulo articuloDb = articuloService.findById(num_articulo);
        if (articuloDb != null) {
            articuloDb.setDescripcion(newArticulo.getDescripcion());
            articuloService.update(articuloDb);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{num_articulo}")
    public ResponseEntity<?> borrar(@PathVariable Integer num_articulo) {
        Articulo articuloDb = articuloService.findById(num_articulo);
        if (articuloDb != null) {
            articuloService.delete(num_articulo);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
