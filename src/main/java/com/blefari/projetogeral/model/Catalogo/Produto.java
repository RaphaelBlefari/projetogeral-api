package com.blefari.projetogeral.model.Catalogo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="Produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProdutoId")
	private Integer ProdutoId;
	
	@Column(name="Nome")
	private String Nome;
	
	@Column(name="Marca")
	private String Marca;
	
	@Column(name="Preco")
	private BigDecimal Preco;
	
	public Boolean IsNull() {
		return this.ProdutoId == null;
	}
		
	public Produto() {		
		IsNull();
	}
	
	
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
