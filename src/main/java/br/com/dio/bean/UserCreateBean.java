package br.com.dio.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.dio.model.FuncoesEnum;
import br.com.dio.model.User;
import br.com.dio.service.UserService;

@Named
@ViewScoped
public class UserCreateBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userBO = new UserService();
	private User user = new User();
	private String tipo;

	@PostConstruct
	public void init() {
		this.userBO = new UserService();
	}

	public String validarECriar() {
		setTipoUser();
		userBO.saveOrUptade(user);
		return "employeeList/form_employee?faces-redirect=true";
	}

	private void setTipoUser() {
		if(tipo.contentEquals("Administrador")) {
			user.setTypeUser(FuncoesEnum.ADMINISTRADOR);
		}else if(tipo.contentEquals("Vendedor")) {
			user.setTypeUser(FuncoesEnum.VENDEDOR);
		}else {
			user.setTypeUser(FuncoesEnum.ANALISTA);
		}
	}

	public List<String> getTipos() {
		List<String> tipos = new ArrayList<String>();
		tipos.add("Administrador");
		tipos.add("Vendedor");
		tipos.add("Analista");
		return tipos;
	}

	public UserService getUserBO() {
		return userBO;
	}

	public void setUserBO(UserService userBO) {
		this.userBO = userBO;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
