package br.com.dio.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.dio.bean.UserUtils;
import br.com.dio.model.Employee;
import br.com.dio.util.SQLUtils;

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
		obj.setAppId(UserUtils.getAppId());
		System.out.println(obj.getAppId());
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
		entityManager.remove(entityManager.find(Employee.class, obj.getId()));
		transaction.commit();
	}

	@Override
	public Employee findById(int id) {
		Employee obj = new Employee();
		EntityManager entityManager = emf.createEntityManager();
		obj = entityManager.find(Employee.class, id);
		return obj;
	}

	@Override
	public List<Employee> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		String where = SQLUtils.builderWhere(UserUtils.getAppId(), "");
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT vo.id_employee, " +
				"vo.birthday, " +
				"vo.cpf, " +
				"vo.funcao, " +
				"vo.lastname, " +
				"vo.name, " +
				"vo.registerEmployee, " +
				"vo.rg, " +
				"vo.salary, " +
				"vo.telefone " +
				"FROM tb_employee vo" +
				where +
				"ORDER BY name");
		EntityManager entityManager = emf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> employeeResultSet = query.getResultList();
		List<Employee> list = new ArrayList<>();
		if (!employeeResultSet.isEmpty()) {
			for (Object[] o : employeeResultSet) {
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
