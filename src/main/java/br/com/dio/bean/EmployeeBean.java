package br.com.dio.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dio.model.Employee;

@Named
@ViewScoped
public class EmployeeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Employee employee;
	
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
		employees.add(employee);
		clean();
		System.out.println("Sucesso");
	}
	
	private void clean() {
		this.employee = new Employee();
	}
	
}
