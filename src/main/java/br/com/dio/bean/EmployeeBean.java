package br.com.dio.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dio.model.Employee;
import br.com.dio.service.EmployeeService;

@Named
@ViewScoped
public class EmployeeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EmployeeService service = new EmployeeService();
	
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
	
	public String addEmployee(){
		employee.setId(-1);
		Employee e = employee;
		service.saveOrUptade(e);
		clean();
		return "form_employee.xhtml?faces-redirect=true";
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
