package br.com.dio.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.dio.Session.SessionContext;
import br.com.dio.model.User;
import br.com.dio.service.UserService;

@Named
@ViewScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private UserService userBO= new UserService();
	private String email;
	private String login;
	private String senha;
	
	@PostConstruct
	public void init() {
		this.userBO = new UserService();
	}

	public User getUser() {
		return (User) SessionContext.getInstance().getUsuarioLogado();
	}
	public String doLogin() {
		User user = userBO.acessLogin(login, senha);

		if (user == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha ou Email incorretos!", ""));
			FacesContext.getCurrentInstance().validationFailed();
			return "";
		}

		SessionContext.getInstance().setAttribute("usuarioLogado", user);
		return "/restricted/form_employee.xhtml?faces-redirect=true";

	}
	
	public String doLogout() {
		SessionContext.getInstance().encerrarSessao();
		return "/form_login.xhtml?faces-redirect=true";
	}
	
	public void solicitarNovaSenha() {
		userBO.gerarNovaSenha(login, email);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Nova Senha enviada para o email " + email, ""));
	}
	
	public String resetSenha() {
		return "reset_senha.xhtml?faces-redirect=true";
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
