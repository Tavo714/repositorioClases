package com.example.emisor1.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emisor1.Modelo.Mensaje;

import jakarta.jms.Queue;

@RestController
public class ControladorMensaje {

    @Autowired
    JmsTemplate p;

    @PostMapping("/Mensaje")
    public ResponseEntity<Mensaje> enviarmensaje(@RequestBody Mensaje m){
        try{
            Queue cola=p.getConnectionFactory()
                        .createConnection()
                        .createSession()
                        .createQueue("USUARIO1");
            Mensaje ob=new Mensaje(m.getComentario(), m.getTipo()+" [USUARIO1] ");
            p.convertAndSend(cola,ob);
            return new ResponseEntity<>(ob, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Leer")
	public ResponseEntity<Mensaje> leermensaje(){
		try {
			p.setReceiveTimeout(2000);
			Mensaje ob=(Mensaje) p.receiveAndConvert("USUARIO2");
			return new ResponseEntity<>(ob,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}	

}