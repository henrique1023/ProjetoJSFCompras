package br.com.dio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_employee")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long registerEmployee;
	private String name;
	private String lastname;
	private String cpf;
	private String rg;
	private FuncoesEnum funcao;
	private Date birthday;
	private String telefone;
	private Float salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Long registerEmployee, String name, String lastname, String cpf, String rg, FuncoesEnum funcao,
			Date birthday, String telefone, Float salary) {
		super();
		this.registerEmployee = registerEmployee;
		this.name = name;
		this.lastname = lastname;
		this.cpf = cpf;
		this.rg = rg;
		this.funcao = funcao;
		this.birthday = birthday;
		this.telefone = telefone;
		this.salary = salary;
	}


	public Long getRegisterEmployee() {
		return registerEmployee;
	}



	public void setRegisterEmployee(Long registerEmployee) {
		this.registerEmployee = registerEmployee;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getRg() {
		return rg;
	}



	public void setRg(String rg) {
		this.rg = rg;
	}

	public FuncoesEnum getFuncao() {
		return funcao;
	}



	public void setFuncao(FuncoesEnum funcao) {
		this.funcao = funcao;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public Float getSalary() {
		return salary;
	}



	public void setSalary(Float salary) {
		this.salary = salary;
	}



	@Override
	public int hashCode() {
		return Objects.hash(registerEmployee);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(registerEmployee, other.registerEmployee);
	}
	
	
}
