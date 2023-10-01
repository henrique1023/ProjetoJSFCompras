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
@Table(name = "tb_empresa")
public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEmpresa;
	private String nomeEmpresa;
	private Long cnpj;
	private String endereco;
	private String email;
	private Long telefone;
	private Double faturamentoMensal;
	private Double capitalSocial;
	private String ramoAtuacao;
	private String estado;
	private Double balanco;
	private Double lucro;
	private int appId;
	private boolean deletado = false;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}
	
	public Empresa() {
		// TODO Auto-generated constructor stub
	}
	
	public Empresa(Integer idEmpresa, String nomeEmpresa, Long cnpj, String endereco, String email, Long telefone,
			Double faturamentoMensal, Double capitalSocial, String ramoAtuacao, String estado, Double balanco,
			Double lucro) {
		super();
		this.idEmpresa = idEmpresa;
		this.nomeEmpresa = nomeEmpresa;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.faturamentoMensal = faturamentoMensal;
		this.capitalSocial = capitalSocial;
		this.ramoAtuacao = ramoAtuacao;
		this.estado = estado;
		this.balanco = balanco;
		this.lucro = lucro;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Double getFaturamentoMensal() {
		return faturamentoMensal;
	}

	public void setFaturamentoMensal(Double faturamentoMensal) {
		this.faturamentoMensal = faturamentoMensal;
	}

	public Double getCapitalSocial() {
		return capitalSocial;
	}

	public void setCapitalSocial(Double capitalSocial) {
		this.capitalSocial = capitalSocial;
	}

	public String getRamoAtuacao() {
		return ramoAtuacao;
	}

	public void setRamoAtuacao(String ramoAtuacao) {
		this.ramoAtuacao = ramoAtuacao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getBalanco() {
		return balanco;
	}

	public void setBalanco(Double balanco) {
		this.balanco = balanco;
	}

	public Double getLucro(double v) {
		return lucro;
	}

	public void setLucro(Double lucro) {
		this.lucro = lucro;
	}

	public void setDeletado(boolean deletado) {
		this.deletado = deletado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, idEmpresa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(idEmpresa, other.idEmpresa);
	}
	
	
	
}
