package br.com.dio.service;

import java.util.List;

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
	
	public List<User> verificaSeExiste(String email) {
		List<User> u = dao.findByNome(email);
		return u;
	}
	
	public User acessLogin(String email, String senha) {
		User us = dao.isUserReadyToLogin(email, senha);
		return us;
	}
	
	public void gerarNovaSenha(String login, String email) {
		//implementar
	}
	
	public List<User> findAll(){
		List<User> result = dao.findAll();
		return result;
	}
}
