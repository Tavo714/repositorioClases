package pe.edu.idat.dsi.daa2.datacampusback.controllers;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.dsi.daa2.datacampusback.models.User;
import pe.edu.idat.dsi.daa2.datacampusback.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/users") //Define valor de ruta de API

public class UserRestController {

    private UserService userService;
    //Se genera el constructor con SOURCE ACTION (click derecho)
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    //LISTAR
    @GetMapping()
    public List<User> getAll() {
        return userService.getAll();
    }   
    
    //BUSCAR
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }  

    //CREAR
    @PostMapping()
    public User insert(@RequestBody User entity) {        
        return userService.insert(entity);
    }   

    //MODIFICAR
    @PutMapping("/{id}") //El path no se necesita pues esta a nivel de cabecera
    public User update(@PathVariable Long id, @RequestBody User entity) {
        entity.setId(id);
        return userService.update(entity);   
        
    }

    //ELIMINAR
    @DeleteMapping("/{id}") //El path no se necesita pues esta a nivel de cabecera
    public String delete(@PathVariable Long id) { //DELETE Y BODY no reciben @RequestBody
        boolean hasDeleted = userService.delete(id);
        return hasDeleted? "El usuario ha sido eliminado correctamente" : "Ocurrio un problema al eliminar el usuario";
        
    }
}
