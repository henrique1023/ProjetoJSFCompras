package br.com.dio.dao;

import java.util.List;

import br.com.dio.model.Employee;

public interface IEmployee {
	void insert(Employee obj);
	void update(Employee obj);
	void delete(Employee obj);
	Employee findById(Employee obj);
	List<Employee> findByNome(String nome);
	List<Employee> findAll();
}
