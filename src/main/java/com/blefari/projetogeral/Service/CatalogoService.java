package com.blefari.projetogeral.Service;

import com.blefari.projetogeral.model.Catalogo.Produto;
import java.util.List;

public interface  CatalogoService {

	public 	List<Produto> RetornaProdutos();

	public Produto RetornaProduto(Integer produtoid);
	
	public Produto InseriProduto(Produto produto);
	
	public Produto AtualizaProduto(Produto produto);
	
	public Boolean DeletaProduto(Integer produtoid);
}
