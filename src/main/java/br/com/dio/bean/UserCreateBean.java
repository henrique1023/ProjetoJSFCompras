package br.com.dio.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.dio.service.UserService;

@Named
@ViewScoped
public class UserCreateBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userBO= new UserService();
	private String email;
	private String login;
	private String senha;
	

	@PostConstruct
	public void init() {
		this.userBO = new UserService();
	}
	
	public void validarECriar() {
		
	}

	public UserService getUserBO() {
		return userBO;
	}


	public void setUserBO(UserService userBO) {
		this.userBO = userBO;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
