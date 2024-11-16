package pe.edu.idat.dsi.daa2.datacampusback.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pe.edu.idat.dsi.daa2.datacampusback.models.User;

import pe.edu.idat.dsi.daa2.datacampusback.services.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;






@Controller
@RequestMapping("/users") //users sera la ruta base para todo lo que se genere aqui

public class UserController {

    private UserService userService;
    private User userCreated;
    private User userModified;
    private boolean userDeleted;

    public UserController(UserService userService){
        this.userService=userService;
        userService=null;
        userModified=null;
        userDeleted=false;
    }

    @GetMapping()
    public String goToUserIndexView(Model model) {
        model.addAttribute("title","Usuarios");
        model.addAttribute("headers", populateHeaders());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("userHasCreated", userCreated !=null);
        model.addAttribute("userHasModified", userModified !=null);
        model.addAttribute("userHasDeleted", userDeleted);
        String userCreatedMessage=userCreated !=null? "El usuario "+userCreated.getName() + " "+userCreated.getLastname()+" ha sido registrado correctamente con codigo " +userCreated.getId() : "";
        model.addAttribute("userCreatedMessage", userCreatedMessage);
        String userModifiedMessage=userModified !=null? "Los datos del usuario "+userModified.getName() + " "+userModified.getLastname()+" han sido actualizados correctamente " : "";
        model.addAttribute("userModifiedMessage", userModifiedMessage);
        userCreated=null;
        userModified=null;
        userDeleted=false;
        return "students";
    }

    @GetMapping("/new")
    public String goToUserCreateView(Model model) {
        model.addAttribute("title","Nuevo Usuario");
        model.addAttribute("currentUser", new User());
        return "student-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User entity, Model model) {
        userCreated = userService.insert(entity);    
        model.addAttribute("userCreated", userCreated);    
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String goToUserEditView(@PathVariable Long id, Model model) {
        User toUpdate = userService.getById(id);
        if(toUpdate==null) return "redirect:/users";

        model.addAttribute("title","Editar Usuario");
        model.addAttribute("currentUser", toUpdate);
        return "student-edit";
    }

    @PostMapping("/modify")
    public String modify(@ModelAttribute User entity, Model model) {
        userModified = userService.update(entity);    
        model.addAttribute("userModified", userModified);    
        return "redirect:/users";
    }   

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userDeleted = userService.delete(id);  
        if(!userDeleted)  
            return ResponseEntity.badRequest().build();    
        return ResponseEntity.ok("El usuario ha sido eliminado correctamente");
    }    
    
    private List<String> populateHeaders(){
        List<String> headers= new ArrayList<>();
        headers.add("id");
        headers.add("Nombres");
        headers.add("Apellidos");
        headers.add("Usuario");
        headers.add("Clave");
        headers.add("Correo");
        headers.add("# Telefonico");

        headers.add("Acciones");

        return headers;
    }

}
