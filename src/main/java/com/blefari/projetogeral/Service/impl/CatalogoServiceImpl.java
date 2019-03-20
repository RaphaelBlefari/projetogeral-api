package com.blefari.projetogeral.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blefari.projetogeral.Service.CatalogoService;
import com.blefari.projetogeral.model.Catalogo.Produto;
import com.blefari.projetogeral.repository.Catalogo.CatalogoRepository;


@Service
public class CatalogoServiceImpl implements CatalogoService{

	@Autowired
	private CatalogoRepository catalogoRepository;

	public List<Produto> RetornaProdutos() {

		List<Produto> myList = new ArrayList<Produto>();
		myList = catalogoRepository.findAll();		
		return myList;
	}

	public Produto RetornaProduto(Integer produtoid) {

		Produto produto = new Produto();
		produto = catalogoRepository.findById(produtoid).orElse(new Produto());	
		return produto;
	}

	public Produto InseriProduto(Produto produto) {

		return catalogoRepository.save(produto);	
	}

	public Boolean DeletaProduto(Integer produtoid) {	
		
			catalogoRepository.deleteById(produtoid);	
			return true;
	}
	
	public Produto AtualizaProduto(Produto produto) {

		return catalogoRepository.save(produto);	
	}
}
