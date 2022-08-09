package br.com.dio.bean;

import java.sql.SQLException;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.dio.Session.SessionContext;
import br.com.dio.dao.UserDaoHibernate;
import br.com.dio.model.User;

@Named
@SessionScoped
public class UsuarioLogadoMBImpl {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(UsuarioLogadoMBImpl.class);

	@ManagedProperty(value = "#{userBO}")
	private UserDaoHibernate userBO;

	private String email;
	private String login;
	private String senha;

	/**
	 * Retorna usuario logado
	 */
	public User getUser() {
		return (User) SessionContext.getInstance().getUsuarioLogado();
	}

	public String doLogin() {
		logger.info("Tentando logar com usuário " + login);
		User user = userBO.isUserReadyToLogin(login, senha);

		if (user == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha ou Email incorretos!", ""));
			FacesContext.getCurrentInstance().validationFailed();
			return "";
		}

		logger.info("Login efetuado com sucesso");
		SessionContext.getInstance().setAttribute("usuarioLogado", user);
		return "/index.xhtml?faces-redirect=true";

	}

	public String doLogout() {
		logger.info("Fazendo logout com usuário " + SessionContext.getInstance().getUsuarioLogado());
		SessionContext.getInstance().encerrarSessao();
		logger.info("Logout realizado com sucesso !");
		return "/security/form_login.xhtml?faces-redirect=true";
	}

	public void solicitarNovaSenha() {

		userBO.gerarNovaSenha(login, email);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Nova Senha enviada para o email " + email, ""));
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
