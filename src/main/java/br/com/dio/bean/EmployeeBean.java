package br.com.dio.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.dio.dao.DaoFactory;
import br.com.dio.dao.EmployeeDaoHibernate;
import br.com.dio.model.Employee;
import br.com.dio.service.EmployeeService;

@Named
@ViewScoped
public class EmployeeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EmployeeService service;
	
	private Employee employee = new Employee();
	
	private List<String> Funcoes;
	
	private List<Employee> employees = new ArrayList<>();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(){
		service.saveOrUptade(employee);
		clean();
	}
	
	private void clean() {
		this.employee = new Employee();
	}
	
	public List<String> getFuncoes(){
		List<String> funcoes = new ArrayList<String>();
		funcoes.add("ADMINISTRADOR");
		funcoes.add("VENDEDOR");
		funcoes.add("ANALISTA");
		return funcoes;
	}
	
}
