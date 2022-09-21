package br.com.dio.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;

import br.com.dio.model.Employee;
import br.com.dio.service.EmployeeService;

@Named
@ViewScoped
public class DeleteEmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private EmployeeService service = new EmployeeService();

	private Employee employee = new Employee();

	public void init() {
		String paramResposta = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest()).getParameter("meuParametro");

		if (paramResposta != null && !paramResposta.isEmpty()) {
			int codigo = Integer.parseInt(paramResposta);
			employee = service.findById(codigo);
		}
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void closeDialog() {
		PrimeFaces.current().dialog().closeDynamic(null);
	}

	public void deleteEmployee() {
		service.remove(employee);
		closeDialog();
	}

}
