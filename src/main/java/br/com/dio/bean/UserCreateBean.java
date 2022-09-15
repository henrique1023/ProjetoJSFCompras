package br.com.dio.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.dio.model.User;
import br.com.dio.service.UserService;

@Named
@ViewScoped
public class UserCreateBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userBO= new UserService();
	private User user = new User();
	

	@PostConstruct
	public void init() {
		this.userBO = new UserService();
	}
	
	public String validarECriar() {
		userBO.saveOrUptade(user);
		return "form_employee?faces-redirect=true";
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
	
	
	
}
