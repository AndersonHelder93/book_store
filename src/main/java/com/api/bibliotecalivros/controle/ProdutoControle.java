package com.api.bibliotecalivros.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.bibliotecalivros.modelo.ProdutoModelo;
import com.api.bibliotecalivros.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/api")
public @ResponseBody class ProdutoControle {
	
	//Ações
	@Autowired
	private ProdutoRepositorio acoes;
	
	//Inicio
	@RequestMapping(value ="/produtos", method=RequestMethod.GET)
	public @ResponseBody List<ProdutoModelo> listar() { //@ResponseBody, anotação que realiza a exibição dos resultados dos métodos no navegador.
		return acoes.findAll();
	}
	
	//Cadastrar produtos
	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}
	
	//Filtrar Produtos
	@RequestMapping(value="/produtos/{codigo}", method=RequestMethod.GET)
	public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer codigo) {
		return acoes.findByCodigo(codigo); 
	}
	
	//Editar Produtos
	@RequestMapping(value="/produtos", method=RequestMethod.PUT)
	public @ResponseBody ProdutoModelo editar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}
	
	//Deletar produtos
	@RequestMapping(value="/produtos/{codigo}", method=RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Integer codigo){
		ProdutoModelo produto = filtrar(codigo);
		
		this.acoes.delete(produto);
	}
	
}
