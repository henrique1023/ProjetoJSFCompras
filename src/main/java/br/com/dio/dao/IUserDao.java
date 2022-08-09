package br.com.dio.dao;

import java.util.List;

import br.com.dio.model.User;

public interface IUserDao {
	void insert(User obj);
	void update(User obj);
	void delete(User obj);
	User findById(User obj);
	List<User> findByNome(String nome);
	List<User> findAll();
}
