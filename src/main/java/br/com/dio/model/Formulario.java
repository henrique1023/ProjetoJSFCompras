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
@Table(name = "tb_formulario")
public class Formulario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "cod_formulario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codFormulario;
	private String pesquisaInternet;
	private String consultaProtesto;
	private String consultaTjsp;
	private String consultaSintegra;
	private String consultaReceitaFederal;
	private String consultaJucesp;
	private Integer pontosObtidos;
	private Integer pontosMaximos;
	private Integer pontosNecessarios;
	private Double valorAprovado;
	private Double valorAvista;
	private StatusAprovacao status;
	private int appId;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Employee funcionario;
	
	@ManyToOne
	@JoinColumn(name = "serasa_id")
	private ConsultaSerasa serasa;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	public Formulario() {
		// TODO Auto-generated constructor stub
	}

	public Formulario(Long codFormulario, String pesquisaInternet, String consultaProtesto, String consultaTjsp,
			String consultaSintegra, String consultaReceitaFederal, String consultaJucesp, Integer pontosObtidos,
			Integer pontosMaximos, Integer pontosNecessarios, Double valorAprovado, Double valorAvista,
			StatusAprovacao status, Empresa empresa, Employee funcionario, ConsultaSerasa serasa, Pedido pedido) {
		super();
		this.codFormulario = codFormulario;
		this.pesquisaInternet = pesquisaInternet;
		this.consultaProtesto = consultaProtesto;
		this.consultaTjsp = consultaTjsp;
		this.consultaSintegra = consultaSintegra;
		this.consultaReceitaFederal = consultaReceitaFederal;
		this.consultaJucesp = consultaJucesp;
		this.pontosObtidos = pontosObtidos;
		this.pontosMaximos = pontosMaximos;
		this.pontosNecessarios = pontosNecessarios;
		this.valorAprovado = valorAprovado;
		this.valorAvista = valorAvista;
		this.status = status;
		this.empresa = empresa;
		this.funcionario = funcionario;
		this.serasa = serasa;
		this.pedido = pedido;
	}

	public Long getCodFormulario() {
		return codFormulario;
	}

	public void setCodFormulario(Long codFormulario) {
		this.codFormulario = codFormulario;
	}

	public String getPesquisaInternet() {
		return pesquisaInternet;
	}

	public void setPesquisaInternet(String pesquisaInternet) {
		this.pesquisaInternet = pesquisaInternet;
	}

	public String getConsultaProtesto() {
		return consultaProtesto;
	}

	public void setConsultaProtesto(String consultaProtesto) {
		this.consultaProtesto = consultaProtesto;
	}

	public String getConsultaTjsp() {
		return consultaTjsp;
	}

	public void setConsultaTjsp(String consultaTjsp) {
		this.consultaTjsp = consultaTjsp;
	}

	public String getConsultaSintegra() {
		return consultaSintegra;
	}

	public void setConsultaSintegra(String consultaSintegra) {
		this.consultaSintegra = consultaSintegra;
	}

	public String getConsultaReceitaFederal() {
		return consultaReceitaFederal;
	}

	public void setConsultaReceitaFederal(String consultaReceitaFederal) {
		this.consultaReceitaFederal = consultaReceitaFederal;
	}

	public String getConsultaJucesp() {
		return consultaJucesp;
	}

	public void setConsultaJucesp(String consultaJucesp) {
		this.consultaJucesp = consultaJucesp;
	}

	public Integer getPontosObtidos() {
		return pontosObtidos;
	}

	public void setPontosObtidos(Integer pontosObtidos) {
		this.pontosObtidos = pontosObtidos;
	}

	public Integer getPontosMaximos() {
		return pontosMaximos;
	}

	public void setPontosMaximos(Integer pontosMaximos) {
		this.pontosMaximos = pontosMaximos;
	}

	public Integer getPontosNecessarios() {
		return pontosNecessarios;
	}

	public void setPontosNecessarios(Integer pontosNecessarios) {
		this.pontosNecessarios = pontosNecessarios;
	}

	public Double getValorAprovado() {
		return valorAprovado;
	}

	public void setValorAprovado(Double valorAprovado) {
		this.valorAprovado = valorAprovado;
	}

	public Double getValorAvista() {
		return valorAvista;
	}

	public void setValorAvista(Double valorAvista) {
		this.valorAvista = valorAvista;
	}

	public StatusAprovacao getStatus() {
		return status;
	}

	public void setStatus(StatusAprovacao status) {
		this.status = status;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Employee getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Employee funcionario) {
		this.funcionario = funcionario;
	}

	public ConsultaSerasa getSerasa() {
		return serasa;
	}

	public void setSerasa(ConsultaSerasa serasa) {
		this.serasa = serasa;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
}
