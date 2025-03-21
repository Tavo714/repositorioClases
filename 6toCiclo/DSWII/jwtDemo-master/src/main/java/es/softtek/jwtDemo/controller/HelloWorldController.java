package es.softtek.jwtDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="IDAT") String name) {
		return "Hola, bienvenidos a mi web service con uso de JWT Token "+name+"!!";
	}
}
