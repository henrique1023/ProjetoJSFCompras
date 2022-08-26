package br.com.dio.service;

import java.util.List;

import br.com.dio.dao.DaoFactory;
import br.com.dio.dao.EmployeeDaoHibernate;
import br.com.dio.model.Employee;

public class EmployeeService {
	
	private EmployeeDaoHibernate dao = DaoFactory.createEmployeeDao();
	
	public List<Employee> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUptade(Employee obj) {
		if(obj.getRegisterEmployee() == -1) {
			dao.insert(obj);
		}else {
			dao.update(obj);
		}
	}
	
	public void remove(Employee obj) {
		dao.delete(obj);
	}
	
	public List<Employee> findByNome(String nome){
		return dao.findByNome(nome);
	}
}	
