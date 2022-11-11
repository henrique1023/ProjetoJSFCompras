package br.com.dio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto_pk")
public class ProdutoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cod_produto_pk")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codProdutoPK;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	private int quantidade;
	private double total;
	
	public ProdutoPK() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoPK(long codProdutoPK, Produto produto, int quantidade, double total) {
		super();
		this.codProdutoPK = codProdutoPK;
		this.produto = produto;
		this.quantidade = quantidade;
		this.total = total;
	}

	public long getCodProdutoPK() {
		return codProdutoPK;
	}

	public void setCodProdutoPK(long codProdutoPK) {
		this.codProdutoPK = codProdutoPK;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
