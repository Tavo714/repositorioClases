package com.espinozajg.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {

	@RequestMapping("greetings")
	public String greetings(@RequestParam(value="name", defaultValue="validando Spring con JWT-IDAT") String name) {
		return "Hola, {" + name + "}";
	}
}
