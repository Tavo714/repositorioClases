package com.example.emisorusuario1vmga.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emisorusuario1vmga.Model.Mensaje;

import jakarta.jms.Queue;

@RestController
public class ControladorMensaje {

    @Autowired
    private JmsTemplate p;

    @GetMapping("/Receptor1")
    public ResponseEntity<Mensaje> leermensaje(){
        try{
            p.setReceiveTimeout(2000);
            Mensaje ob=(Mensaje) p.receiveAndConvert("USER2");
            return new ResponseEntity<>(ob, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Emisor1")
    public ResponseEntity<Mensaje> enviarmensaje(@RequestBody Mensaje m) {
        try {
            Queue cola = p.getConnectionFactory()
                          .createConnection()
                          .createSession()
                          .createQueue("USER1");

            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            Mensaje ob = new Mensaje(fechaHora, m.getComentario(), m.getUsuario() + " [USER1]");
            
            p.convertAndSend(cola, ob);
            
            return new ResponseEntity<>(ob, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
