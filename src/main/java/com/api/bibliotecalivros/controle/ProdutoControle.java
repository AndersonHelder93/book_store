package com.api.bibliotecalivros.controle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public @ResponseBody class ProdutoControle {
	
	//Inicio
	@RequestMapping(value = "", method=RequestMethod.GET)
	public @ResponseBody String inicio() {
		return "Bem Vindo a API de Produtos!";
	}
	//Sobre
	@RequestMapping(value = "/sobre", method=RequestMethod.GET)
	public @ResponseBody String sobre() {
		return "Sobre a API..";
	}
	//Contato
	@RequestMapping(value = "/contato", method=RequestMethod.GET)
	public @ResponseBody String contato() {
		return "Fale Conosco :D";
	}
}
