package pe.edu.idat.dsi.daa2.demomvc.controllers;

import java.time.temporal.ValueRange;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.idat.dsi.daa2.demomvc.models.User;



@Controller // Es lo primero que hay que agregar manualmente

public class HomeController {
    // GetMapping es lo segundo. Se borra "path", el request y el return.
    @GetMapping()
    //En goToHomeView, elegir la 2da opcion de Model
    public String goToHomeView(Model model) {
        User user = new User(1, "Gustavo", "Valera", "43653459", "958722698");

        model.addAttribute("siteTitle", "Campus IDAT");
        model.addAttribute("welcomeMessage", "Bievenido a Campus IDAT");
        model.addAttribute("cdnBootstrap", "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css");
        model.addAttribute("user", user);
        model.addAttribute("siteContent", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nulla dignissimos temporibus vitae atque alias facilis placeat commodi sequi, aliquid dolorem repellendus dolor autem labore, impedit assumenda veniam voluptatibus laboriosam odit.");
        return "home";
    }
    
    }
    




