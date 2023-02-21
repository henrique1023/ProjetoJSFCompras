package br.com.dio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cod_pedido")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codPedido;
	private Double totalPedido;
	private Double totalPreco;
	private FormaDePagamento formaPagamento;

	@ManyToOne
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	
	@OneToMany
	@JoinColumn(name = "produtos_id")
	private List<ProdutoPK> produtos = new ArrayList<>();
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Pedido(long codPedido, Double totalPedido, Double totalPreco, FormaDePagamento formaPagamento,
			List<ProdutoPK> produtos) {
		super();
		this.codPedido = codPedido;
		this.totalPedido = totalPedido;
		this.totalPreco = totalPreco;
		this.formaPagamento = formaPagamento;
		this.produtos = produtos;
	}

	public long getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(long codPedido) {
		this.codPedido = codPedido;
	}

	public Double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public Double getTotalPreco() {
		return totalPreco;
	}

	public void setTotalPreco(Double totalPreco) {
		this.totalPreco = totalPreco;
	}

	public FormaDePagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaDePagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<ProdutoPK> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoPK> produtos) {
		this.produtos = produtos;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
