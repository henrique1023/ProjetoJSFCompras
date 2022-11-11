package br.com.dio.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cod_produto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codProduto;
	private String nome;
	private Double preco;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	public Produto(long codProduto, String nome, Double preco) {
		super();
		this.codProduto = codProduto;
		this.nome = nome;
		this.preco = preco;
	}

	public long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(long codProduto) {
		this.codProduto = codProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return codProduto == other.codProduto;
	}
	
	

}
