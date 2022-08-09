package br.com.dio.service;

import br.com.dio.dao.DaoFactory;
import br.com.dio.dao.UserDaoHibernate;
import br.com.dio.model.User;

public class UserService {
	
	private UserDaoHibernate dao = DaoFactory.createUserDao();
	
	public void saveOrUptade(User obj) {
		if(obj.getId() == null) {
			dao.insert(obj);
		}else {
			dao.update(obj);
		}
	}
	
	public User acessLogin(String email, String senha) {
		User us = dao.isUserReadyToLogin(email, senha);
		System.out.println(us);
		return us;
	}
	
	public void gerarNovaSenha(String login, String email) {
		//implementar
	}
}
