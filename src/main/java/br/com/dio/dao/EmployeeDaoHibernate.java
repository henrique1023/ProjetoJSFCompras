package br.com.dio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.dio.model.Employee;

public class EmployeeDaoHibernate implements IEmployee{
	
	private EntityManagerFactory emf;
	
	public EmployeeDaoHibernate(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(Employee obj) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		obj.setId(null);
		transaction.begin();
		entityManager.persist(obj);
		transaction.commit();
	}

	@Override
	public void update(Employee obj) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(obj);
		transaction.commit();
	}

	@Override
	public void delete(Employee obj) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(entityManager.find(Employee.class, obj.getRegisterEmployee()));
		transaction.commit();
	}

	@Override
	public Employee findById(Employee obj) {
		EntityManager entityManager = emf.createEntityManager();
		obj = entityManager.find(Employee.class, obj.getRegisterEmployee());
		return obj;
	}

	@Override
	public List<Employee> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT tb_employee.* FROM tb_emp " + "ORDER BY nomeEmployee");
		EntityManager entityManager = emf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> EmployeeResultSet = query.getResultList();
		List<Employee> list = new ArrayList<>();
		if (!EmployeeResultSet.isEmpty()) {
			for (Object[] o : EmployeeResultSet) {
				Employee emp;
				emp = instatiateEmployee(o);
				list.add(emp);
			}
		}

		return list;
	}

	private Employee instatiateEmployee(Object[] o) {
		// TODO Auto-generated method stub
		return null;
	}

}
