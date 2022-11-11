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
@Table(name = "tb_consulta_serasa")
public class ConsultaSerasa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cod_consulta")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codConsulta;
	private Double limiteSerasa;
	private String riscoSerasa;
	private Integer scoreSerasa;
	private Integer numConsultaSerasa;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	public ConsultaSerasa() {
		// TODO Auto-generated constructor stub
	}

	public ConsultaSerasa(long codConsulta, Double limiteSerasa, String riscoSerasa, Integer scoreSerasa,
			Integer numConsultaSerasa, Empresa empresa) {
		super();
		this.codConsulta = codConsulta;
		this.limiteSerasa = limiteSerasa;
		this.riscoSerasa = riscoSerasa;
		this.scoreSerasa = scoreSerasa;
		this.numConsultaSerasa = numConsultaSerasa;
		this.empresa = empresa;
	}

	public long getCodConsulta() {
		return codConsulta;
	}

	public void setCodConsulta(long codConsulta) {
		this.codConsulta = codConsulta;
	}

	public Double getLimiteSerasa() {
		return limiteSerasa;
	}

	public void setLimiteSerasa(Double limiteSerasa) {
		this.limiteSerasa = limiteSerasa;
	}

	public String getRiscoSerasa() {
		return riscoSerasa;
	}

	public void setRiscoSerasa(String riscoSerasa) {
		this.riscoSerasa = riscoSerasa;
	}

	public Integer getScoreSerasa() {
		return scoreSerasa;
	}

	public void setScoreSerasa(Integer scoreSerasa) {
		this.scoreSerasa = scoreSerasa;
	}

	public Integer getNumConsultaSerasa() {
		return numConsultaSerasa;
	}

	public void setNumConsultaSerasa(Integer numConsultaSerasa) {
		this.numConsultaSerasa = numConsultaSerasa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
