package com.api.bibliotecalivros.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.bibliotecalivros.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer>{
	
	//Listar todos os produtos
	List<ProdutoModelo>findAll();
	
	//Pesquisar por codigo
	ProdutoModelo findByCodigo(int codigo);//a função findBy percorre a coluna que tem o nome código e depois procura o parâmetro que foi repassado.
	
	//Remover o produto
	void delete(ProdutoModelo produto);
	
	// Cadastrar/Alterar produto
	//ProdutoModelo save(ProdutoModelo produto);
	<ProdMod extends ProdutoModelo> ProdMod save(ProdMod produto);//padrão de cadastro segundo a documentação do spring
}
