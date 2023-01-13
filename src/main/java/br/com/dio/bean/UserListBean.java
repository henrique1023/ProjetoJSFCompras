package br.com.dio.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.dio.model.Employee;
import br.com.dio.model.FuncoesEnum;
import br.com.dio.model.User;
import br.com.dio.service.UserService;

@Named
@ViewScoped
public class UserListBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userBO = new UserService();
	private User user = new User();
	private String tipo = "a";
	private List<User> users = new ArrayList<>();
	private Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

	@PostConstruct
	public void init() {
		user = (User) flash.get("user");
		this.userBO = new UserService();
		if(user == null) {
			user = new User();
		}
	}
	
	public void searchAllUsers() {
		users = userBO.findAll();
	}

	public void clearListUsers() {
		users = null;
	}
	
	public String editar(User e) {
		flash.put("user", e);
		return "/restricted/UserList/alter_user?faces-redirect=true";
	}

	@SuppressWarnings("unused")
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
	
	public void openDialog(User e) {
		Map<String, Object> options = new HashMap<>();
		options.put("modal", true);
		options.put("resizable", false);
		options.put("contentHeight", 200);
		Map<String, List<String>> params = new HashMap<>();
		params.put("meuParametro", Arrays.asList("" + e.getId()));
		PrimeFaces.current().dialog().openDynamic("delete_dialog", options, params);
	}

	public void instanciaDelete(User e) {
		openDialog(e);
	}

	public void closeDialog() {
		PrimeFaces.current().dialog().closeDynamic(null);
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
