package pe.edu.idat.dsi.daa2.demobackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
@GetMapping()
public String goToHomeView(Model model) {
    model.addAttribute("title", "Bienvenido!!!");
    model.addAttribute("welcomeMessage", "Bienvenido de vuelta, Gustavo Andres!!!");
    return "home";
}

}
