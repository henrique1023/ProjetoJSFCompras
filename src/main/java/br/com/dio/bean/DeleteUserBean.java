package br.com.dio.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.dio.model.User;
import br.com.dio.service.UserService;

@Named
@ViewScoped
public class DeleteUserBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private UserService service = new UserService();
	
	private User user = new User();
	
	public void init() {
		String paramResposta = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest()).getParameter("meuParametro");

		if (paramResposta != null && !paramResposta.isEmpty()) {
			int codigo = Integer.parseInt(paramResposta);
			user = service.findById(codigo);
		}
	}
}
