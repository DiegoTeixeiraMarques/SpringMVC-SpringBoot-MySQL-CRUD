package com.mballem.curso.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  						// Identifica a classe como um Controller na aplicação
public class HomeController {
	
	@GetMapping("/") 				// Indica o contexto, neste caso somente a / significa a raiz do projeto
	public String home() {
		return "/home";				// Retorna a página home.html
	}

}
