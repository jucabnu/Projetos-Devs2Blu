package br.com.projetosaula.primeiroprojetospring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// permite que aceite requisições de qualquer site *
@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class HomeController {
	
	public HomeController() {
		System.out.println("Aeeeeee Funcionou essa bagaça");
	}

}
