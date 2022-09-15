package br.com.dio.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import br.com.dio.model.User;
import br.com.dio.service.UserService;

@Named
@RequestScoped
public class ValidateBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserService userBO= new UserService();
	
	@PostConstruct
	public void init() {
		this.userBO = new UserService();
	}
	
	public void validateDuplicatedUser(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
		String us = (String) o;
    	List<User> verifica = userBO.verificaSeExiste(us);
        if (!verifica.isEmpty()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "O usuário já existe");
            throw new ValidatorException(message);
        }
    }
}
