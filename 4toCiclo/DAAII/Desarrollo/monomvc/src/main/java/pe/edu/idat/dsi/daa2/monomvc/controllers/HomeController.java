package pe.edu.idat.dsi.daa2.monomvc.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pe.edu.idat.dsi.daa2.monomvc.models.User;
import org.springframework.web.bind.annotation.PostMapping;




@Controller

public class HomeController {
    private List<User> users;   
    private User currentUser; 

    public HomeController() {
        this.users = populateUserList();
        this.currentUser=new User();
    }

    @GetMapping()
    public String goToHomeView(Model model) {
        model.addAttribute("pageTitle", "Usuarios");
        model.addAttribute("headers", createUserTableHeaders());
        model.addAttribute("users", users);
        model.addAttribute("isSuccessful", currentUser.getId()!=0);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("user", new User(getNextValue()));
        return "home";
    }   

    @PostMapping("/save")
    public String createUser(@ModelAttribute User user, Model model) {
        users.add(user);
        currentUser=user;    
        return "redirect:/";
    }

    public int getNextValue(){
        Optional<User> result = this.users.stream().max((previous, next)-> Integer.compare(previous.getId(),next.getId()));

        if(result.isPresent()){
            return result.get().getId()+1;
        }
        return 1;

    }
    

    public List<String> createUserTableHeaders(){
        List<String> headers = new ArrayList<>();
        headers.add("Id");
        headers.add("Nombre");
        headers.add("Apellido");
        headers.add("DNI");
        headers.add("Usuario");
        headers.add("Clave");
        headers.add("Correo Electronico");
        headers.add("# Telefono");
        return headers;
    }

    public List<User> populateUserList(){
        List<User> users=new ArrayList<>();

        users.add(new User(1, "John", "Doe", "12345", "johndoe", "password1", "johndoe@example.com", "123-456-7890"));
        users.add(new User(2, "Jane", "Smith", "54321", "janesmith", "password2", "janesmith@example.com", "987-654-3210"));
        users.add(new User(3, "Alice", "Johnson", "67890", "alicej", "password3", "alice@example.com", "456-789-0123"));
        users.add(new User(4, "Bob", "Brown", "09876", "bobbrown", "password4", "bob@example.com", "789-012-3456"));
        users.add(new User(5, "Emily", "Davis", "13579", "emilyd", "password5", "emily@example.com", "012-345-6789"));
        users.add(new User(6, "Michael", "Wilson", "24680", "michaelw", "password6", "michael@example.com", "345-678-9012"));
        users.add(new User(7, "Samantha", "Martinez", "11111", "samantham", "password7", "samantha@example.com", "678-901-2345"));
        users.add(new User(8, "Daniel", "Garcia", "22222", "danieldg", "password8", "daniel@example.com", "901-234-5678"));
        users.add(new User(9, "Olivia", "Lopez", "33333", "olivial", "password9", "olivia@example.com", "234-567-8901"));
        users.add(new User(10, "William", "Lee", "44444", "williaml", "password10", "william@example.com", "567-890-1234"));
        users.add(new User(11, "Ava", "Hernandez", "55555", "avah", "password11", "ava@example.com", "890-123-4567"));
        users.add(new User(12, "James", "Young", "66666", "jamesy", "password12", "james@example.com", "123-456-7890"));
        users.add(new User(13, "Mia", "Clark", "77777", "miaclark", "password13", "mia@example.com", "456-789-0123"));
        users.add(new User(14, "Benjamin", "Lewis", "88888", "benjaminl", "password14", "benjamin@example.com", "789-012-3456"));
        users.add(new User(15, "Charlotte", "Hall", "99999", "charlotteh", "password15", "charlotte@example.com", "012-345-6789"));
        users.add(new User(20, "Gustavo", "Valera", "10101", "gustavov", "password20", "gustavov@example.com", "012-345-7777"));
        
        return users;

    }

}
