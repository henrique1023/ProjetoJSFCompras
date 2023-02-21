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
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cod_produto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codProduto;
	@Column(name="nome")
	private String nomeProduto;
	@Column(name="descricao")
	private String descricaoProduto;
	@Column(name="peso")
	private  Double pesoProduto;
	@Column(name="preco")
	private Double precoProduto;
	private int appId;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(long codProduto, String nomeProduto, String descricaoProduto, Double pesoProduto, Double precoProduto) {
		this.codProduto = codProduto;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.pesoProduto = pesoProduto;
		this.precoProduto = precoProduto;
	}

	public long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(long codProduto) {
		this.codProduto = codProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Double getPesoProduto() {
		return pesoProduto;
	}

	public void setPesoProduto(Double pesoProduto) {
		this.pesoProduto = pesoProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
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
	@Override
	public int hashCode() {
		return Objects.hash(codProduto);
	}
}
