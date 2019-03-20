package com.blefari.projetogeral.host.modelResponse;

import java.math.BigDecimal;
 
public class ProdutoResponse {
	

	private Integer ProdutoId;
	

	private String Nome;
	

	private String Marca;
	

	private BigDecimal Preco;
	
	public Integer getProdutoId() {
		return ProdutoId;
	}

	public void setProdutoId(Integer produtoId) {
		ProdutoId = produtoId;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public BigDecimal getPreco() {
		return Preco;
	}

	public void setPreco(BigDecimal preco) {
		Preco = preco;
	}
}
