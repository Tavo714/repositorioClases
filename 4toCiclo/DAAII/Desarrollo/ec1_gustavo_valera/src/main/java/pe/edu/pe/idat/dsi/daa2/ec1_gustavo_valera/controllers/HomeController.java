package pe.edu.pe.idat.dsi.daa2.ec1_gustavo_valera.controllers;

import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.edu.pe.idat.dsi.daa2.ec1_gustavo_valera.models.User;





@Controller

public class HomeController {
    private List<User> users;

    public HomeController() {
        this.users = populateUserList();
    }

    @GetMapping()
    public String goToHomeView(Model model) {
        model.addAttribute("pageTitle", "Estudiantes");
        model.addAttribute("headers", createUserTableHeaders());
        model.addAttribute("users", users);
        
        return "home";
    }

    public List<String> createUserTableHeaders() {
        List<String> headers = new ArrayList<>();
        headers.add("Id");
        headers.add("Nombre");
        headers.add("Apellido");
        headers.add("DNI");
        headers.add("Correo Electronico");
        headers.add("# Telefono");
        return headers;
    }

    public List<User> populateUserList() {
        List<User> users = new ArrayList<>();

        users.add(new User(1, "John", "Doe", "NID123", "john.doe@example.com", "1234567890"));
        users.add(new User(2, "Jane", "Doe", "NID124", "jane.doe@example.com", "1234567891"));
        users.add(new User(3, "Alice", "Smith", "NID125", "alice.smith@example.com", "1234567892"));
        users.add(new User(4, "Bob", "Smith", "NID126", "bob.smith@example.com", "1234567893"));
        users.add(new User(5, "Charlie", "Brown", "NID127", "charlie.brown@example.com", "1234567894"));
        users.add(new User(6, "David", "Clark", "NID128", "david.clark@example.com", "1234567895"));
        users.add(new User(7, "Eva", "Miller", "NID129", "eva.miller@example.com", "1234567896"));
        users.add(new User(8, "Frank", "White", "NID130", "frank.white@example.com", "1234567897"));
        users.add(new User(9, "Grace", "Harris", "NID131", "grace.harris@example.com", "1234567898"));
        users.add(new User(10, "Hank", "Green", "NID132", "hank.green@example.com", "1234567899"));
        users.add(new User(11, "Ivy", "Young", "NID133", "ivy.young@example.com", "1234567800"));
        users.add(new User(12, "Jack", "Wright", "NID134", "jack.wright@example.com", "1234567801"));
        users.add(new User(13, "Kara", "King", "NID135", "kara.king@example.com", "1234567802"));
        users.add(new User(14, "Leo", "Scott", "NID136", "leo.scott@example.com", "1234567803"));
        users.add(new User(15, "Mia", "Hall", "NID137", "mia.hall@example.com", "1234567804"));
        users.add(new User(16, "Noah", "Adams", "NID138", "noah.adams@example.com", "1234567805"));
        users.add(new User(17, "Olivia", "Baker", "NID139", "olivia.baker@example.com", "1234567806"));
        users.add(new User(18, "Paul", "Carter", "NID140", "paul.carter@example.com", "1234567807"));
        users.add(new User(19, "Quinn", "Phillips", "NID141", "quinn.phillips@example.com", "1234567808"));
        users.add(new User(20, "Ruby", "Evans", "NID142", "ruby.evans@example.com", "1234567809"));



        

        return users;
    }
}  

//Profe, aqui una observacion: por motivos que deconozco importo una liberia de seguridad
//y por eso no reconocia la lista. Me demore media hora en encontrar eso, por suerte lo hice.
     

    
    
