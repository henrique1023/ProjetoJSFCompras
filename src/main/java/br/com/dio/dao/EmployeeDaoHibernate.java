package br.com.dio.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		sql.append("SELECT tb_employee.* FROM tb_employee " + "ORDER BY name");
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
		Employee em = new Employee();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		em.setId(Integer.parseInt(o[0].toString()));
		String data = o[1].toString();
		data = data.substring(0, 19).replace('-', '/');
		try {
			em.setBirthday(sdf.parse(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.setCpf(o[2].toString());
		em.setFuncao(o[3].toString());
		em.setLastname(o[4].toString());
		em.setName(o[5].toString());
		em.setRegisterEmployee(Integer.parseInt(o[6].toString()));
		em.setRg(o[7].toString());
		em.setSalary(Float.parseFloat(o[8].toString()));
		em.setTelefone(o[9].toString());
		return em;
	}

}
