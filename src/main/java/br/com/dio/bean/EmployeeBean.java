package br.com.dio.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.dio.model.Employee;
import br.com.dio.service.EmployeeService;

@Named
@ViewScoped
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private EmployeeService service = new EmployeeService();

	private Employee employee = new Employee();

	private List<Employee> employees = new ArrayList<>();

	public void init() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		employee = (Employee) flash.get("employee");
		if (employee == null) {
			employee = new Employee();
		}
	}

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

	public String addEmployee() {
		if (employee.getId() == null) {
			employee.setId(-1);
		}
		service.saveOrUptade(employee);
		clean();
		return "form_employee.xhtml?faces-redirect=true";
	}

	public void searchAllEmployee() {
		employees = service.findAll();
	}

	public void clearListEmployee() {
		employees = null;
	}

	private void clean() {
		this.employee = new Employee();
	}

	public List<String> getFuncoes() {
		List<String> funcoes = new ArrayList<String>();
		funcoes.add("Administrador");
		funcoes.add("Vendedor");
		funcoes.add("Analista");
		return funcoes;
	}

	public String editar(Employee e) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("employee", e);
		return "register_employee?faces-redirect=true";
	}

	public void openDialog(Employee e) {
		Map<String, Object> options = new HashMap<>();
		options.put("modal", true);
		options.put("resizable", false);
		options.put("contentHeight", 200);
		Map<String, List<String>> params = new HashMap<>();
		params.put("meuParametro", Arrays.asList("" + e.getId()));
		PrimeFaces.current().dialog().openDynamic("delete_dialog", options, params);
	}

	public void instanciaDelete(Employee e) {
		openDialog(e);
	}

	public void closeDialog() {
		PrimeFaces.current().dialog().closeDynamic(null);
	}

}
