package pe.valera.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.valera.model.Proyecto;
import pe.valera.service.ProyectoService;
 
@RestController
@RequestMapping("/proyecto")
public class ProyectoRestController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Proyecto> itemsProyecto=proyectoService.findAll();		
		return new ResponseEntity<>(itemsProyecto,HttpStatus.OK); //Http status code
	}
	
	@GetMapping("/buscar/{codigoPro}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer codigoPro) {
		Proyecto proyectoDb=proyectoService.findById(codigoPro);		
		if(proyectoDb!=null) {
			return new ResponseEntity<>(proyectoDb,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Proyecto proyecto) {
		proyectoService.insert(proyecto);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{codigoPro}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer codigoPro,
                                        @RequestBody Proyecto newProyecto) {		
		Proyecto proyectoDb=proyectoService.findById(codigoPro);		
		if(proyectoDb!=null) {
			proyectoDb.setNombrePro(newProyecto.getNombrePro());
			proyectoDb.setLocalPro(newProyecto.getLocalPro());
			proyectoDb.setIngenieroPro(newProyecto.getIngenieroPro());
			proyectoDb.setCodigoAvancePro(newProyecto.getCodigoAvancePro());
			proyectoDb.setFechaAvancePro(newProyecto.getFechaAvancePro());
			proyectoDb.setIngenieroResponsablePro(newProyecto.getIngenieroResponsablePro());
			proyectoDb.setDescripcionAvancePro(newProyecto.getDescripcionAvancePro());
			proyectoDb.setIncidenciasPro(newProyecto.getIncidenciasPro());
			proyectoService.update(proyectoDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	@DeleteMapping("/borrar/{codigoPro}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer codigoPro)
	{
		Proyecto proyectoDb=proyectoService.findById(codigoPro);
		
		if(proyectoDb!=null) {
			proyectoService.delete(codigoPro);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}


}
