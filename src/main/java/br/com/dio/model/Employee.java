package br.com.dio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long registerEmployee;
	private String name;
	private String lastname;
	private String cpf;
	private String rg;
	private TipoEnum tipoEnum;
	private Date birthday;
	private String telefone;
	private Float salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(Long registerEmployee, String name, String lastname, String cpf, String rg, TipoEnum tipoEnum,
			Date birthday, String telefone, Float salary) {
		super();
		this.registerEmployee = registerEmployee;
		this.name = name;
		this.lastname = lastname;
		this.cpf = cpf;
		this.rg = rg;
		this.tipoEnum = tipoEnum;
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
	public TipoEnum getTipoEnum() {
		return tipoEnum;
	}
	public void setTipoEnum(TipoEnum tipoEnum) {
		this.tipoEnum = tipoEnum;
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
