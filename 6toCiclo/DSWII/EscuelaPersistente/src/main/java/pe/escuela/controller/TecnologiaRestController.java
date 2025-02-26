package pe.escuela.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pe.escuela.model.Tecnologia;
import pe.escuela.service.TecnologiaService;
 
@RestController
@RequestMapping("/tecnologia")
public class TecnologiaRestController {
 
	@Autowired
	private TecnologiaService tecnologiaService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Collection<Tecnologia> itemsTecnologia=tecnologiaService.findAll();
		return new ResponseEntity<>(itemsTecnologia,HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Tecnologia tecnologia) {
		tecnologiaService.insert(tecnologia);		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
 
}
