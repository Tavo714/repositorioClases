package pe.company.controller;

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
import pe.company.model.Proyecto;
import pe.company.service.ProyectoService;

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
	
	@GetMapping("/buscar/{codProyecto}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer codProyecto) {
		Proyecto proyecto=proyectoService.findById(codProyecto);		
		if(proyecto!=null) {
			return new ResponseEntity<>(proyecto,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Proyecto proyecto) {
		proyectoService.insert(proyecto);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
 
	@PutMapping("/editar/{codProyecto}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer codProyecto,
                                        @RequestBody Proyecto newProyecto) {		
		Proyecto proyecto=proyectoService.findById(codProyecto);		
		if(proyecto!=null) {
			proyecto.setNombre(newProyecto.getNombre());
			proyecto.setUbicacion(newProyecto.getUbicacion());
			proyecto.setMunicipalidad(newProyecto.getMunicipalidad());
			proyecto.setFecaprobacion(newProyecto.getFecaprobacion());
			proyecto.setFecinicio(newProyecto.getFecinicio());
			proyecto.setInversion(newProyecto.getInversion());
			proyecto.setTiempodesarrollo(newProyecto.getTiempodesarrollo());
			proyecto.setResponsable(newProyecto.getResponsable());
			proyecto.setFinanciera(newProyecto.getFinanciera());
			proyecto.setDescripcion(newProyecto.getDescripcion());
			proyectoService.update(proyecto);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
 
	@DeleteMapping("/borrar/{codProyecto}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer codProyecto)
	{
		Proyecto proyecto=proyectoService.findById(codProyecto);
		
		if(proyecto!=null) {
			proyectoService.delete(codProyecto);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}


}
