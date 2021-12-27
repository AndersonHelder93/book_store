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
import com.api.bibliotecalivros.modelo.RespostaModelo;
import com.api.bibliotecalivros.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/api")
public @ResponseBody class ProdutoControle {
	
	//Ações
	@Autowired
	private ProdutoRepositorio acoes;
	
	//Listar produtos
	@RequestMapping(value ="/produtos", method=RequestMethod.GET)
	public @ResponseBody List<ProdutoModelo> listar() {
		return acoes.findAll();
	}
	
	//Cadastrar Produtos
	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}
	
	//Filtrar produtos
	@RequestMapping(value ="/produtos/{codigo}", method=RequestMethod.GET)
	public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer codigo) {
		return acoes.findByCodigo(codigo);
	}

	//Alteração de dados
	@RequestMapping(value="/produtos", method=RequestMethod.PUT)
	public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto) {
		return acoes.save(produto);
	}
	
	//Deletar
	@RequestMapping(value="/produtos/{codigo}", method=RequestMethod.DELETE)
	public @ResponseBody RespostaModelo deletar(@PathVariable Integer codigo) {
		
		RespostaModelo resposta = new RespostaModelo();
		
		try {
			ProdutoModelo produto = filtrar(codigo);
			this.acoes.delete(produto);
			resposta.setMensagem("Produto Removido com sucesso");
		}catch(Exception erro) {
			resposta.setMensagem("Falaha ao tentar remover: " + erro.getMessage());
		}
		
		return resposta;
	}
}
