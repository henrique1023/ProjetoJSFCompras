package br.com.dio.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_employee")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_employee")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer registerEmployee;
	private String name;
	private String lastname;
	private String cpf;
	private String rg;
	private String funcao;
	private Date birthday;
	private String telefone;
	private Float salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, Integer registerEmployee, String name, String lastname, String cpf, String rg,
			String funcao, Date birthday, String telefone, Float salary) {
		super();
		this.id = id;
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
	
	public String dataFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String d = sdf.format(this.birthday);
		return d;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegisterEmployee() {
		return registerEmployee;
	}

	public void setRegisterEmployee(Integer registerEmployee) {
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
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
		return Objects.hash(cpf, id, registerEmployee, rg);
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
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id)
				&& Objects.equals(registerEmployee, other.registerEmployee) && Objects.equals(rg, other.rg);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", registerEmployee=" + registerEmployee + ", name=" + name + ", lastname="
				+ lastname + ", cpf=" + cpf + ", rg=" + rg + ", funcao=" + funcao + ", birthday=" + birthday
				+ ", telefone=" + telefone + ", salary=" + salary + "]";
	}

	
	
	
}
