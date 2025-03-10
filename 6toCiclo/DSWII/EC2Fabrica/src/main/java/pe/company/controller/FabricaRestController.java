package pe.company.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.company.model.Fabrica;
import pe.company.service.FabricaService;

@RestController
@RequestMapping("/fabrica")
public class FabricaRestController {

    @Autowired
    private FabricaService fabricaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        Collection<Fabrica> itemsFabrica = fabricaService.findAll();
        return new ResponseEntity<>(itemsFabrica, HttpStatus.OK);
    }

    @GetMapping("/buscar/{num_fabrica}")
    public ResponseEntity<?> buscar(@PathVariable Integer num_fabrica) {
        Fabrica fabricaDb = fabricaService.findById(num_fabrica);
        if (fabricaDb != null) {
            return new ResponseEntity<>(fabricaDb, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Fabrica fabrica) {
        fabricaService.insert(fabrica);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editar/{num_fabrica}")
    public ResponseEntity<?> editar(@PathVariable Integer num_fabrica, @RequestBody Fabrica newFabrica) {
        Fabrica fabricaDb = fabricaService.findById(num_fabrica);
        if (fabricaDb != null) {
            fabricaDb.setNombre(newFabrica.getNombre());
            fabricaDb.setDireccion(newFabrica.getDireccion());
            fabricaDb.setTelefonoContacto(newFabrica.getTelefonoContacto());
            fabricaService.update(fabricaDb);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{num_fabrica}")
    public ResponseEntity<?> borrar(@PathVariable Integer num_fabrica) {
        Fabrica fabricaDb = fabricaService.findById(num_fabrica);
        if (fabricaDb != null) {
            fabricaService.delete(num_fabrica);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
