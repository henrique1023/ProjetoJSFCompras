package br.com.dio.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.dio.bean.UserUtils;
import br.com.dio.model.Employee;
import br.com.dio.model.FuncoesEnum;
import br.com.dio.model.User;
import br.com.dio.util.UserUtil;

public class UserDaoHibernate implements IUserDao {

	private EntityManagerFactory emf;

	public UserDaoHibernate(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void insert(User obj) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		// Criptografando a senha
		String password = obj.getSenha();
		obj.setAppId(UserUtils.getAppId());
		obj.setDataCadastro(new Date());
		password = UserUtil.convertStringToMd5(password);
		obj.setSenha(password);
		entityManager.persist(obj);
		transaction.commit();
	}

	@Override
	public void update(User obj) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String password = obj.getSenha();
		password = UserUtil.convertStringToMd5(password);
		obj.setSenha(password);
		entityManager.merge(obj);
		transaction.commit();
	}

	@Override
	public void delete(User obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(User obj) {
		EntityManager entityManager = emf.createEntityManager();
		obj = entityManager.find(User.class, obj.getId());
		return obj;
	}

	@Override
	public List<User> findByNome(String nome) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM tb_user c ");
		sql.append("WHERE c.email = '" + nome +"'");
		EntityManager entityManager = emf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> retorno = query.getResultList();
		List<User> users = new ArrayList<>();
		if (!retorno.isEmpty()) {
			for (Object[] o : retorno) {
				User userFound = instatiateUser(o);
				users.add(userFound);
			}
			return users;
		}
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM tb_user " + "ORDER BY nome");
		EntityManager entityManager = emf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> EmployeeResultSet = query.getResultList();
		List<User> list = new ArrayList<>();
		if (!EmployeeResultSet.isEmpty()) {
			for (Object[] o : EmployeeResultSet) {
				User user;
				user = instatiateUser(o);
				list.add(user);
			}
		}

		return list;
	}

	public void gerarNovaSenha(String login, String email) {

	}

	// Verifica se usuário existe ou se pode logar
	public User isUserReadyToLogin(String email, String senha) {
		email = email.toLowerCase().trim();
		StringBuffer sql = new StringBuffer();
		String password = UserUtil.convertStringToMd5(senha);
		sql.append("SELECT vo.id, " +
				"vo.data_cadastro, " +
				"vo.email, " +
				"vo.nome, " +
				"vo.senha, " +
				"vo.typeUser, " +
				"vo.appId" +
				" FROM tb_user vo ");
		sql.append("WHERE vo.email = '" + email + "' AND vo.senha = '" + password + "'");
		EntityManager entityManager = emf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> retorno = query.getResultList();
		if (!retorno.isEmpty()) {
			for (Object[] o : retorno) {
				User userFound = instatiateUser(o);
				return userFound;
			}
		}

		return null;
	}

	private User instatiateUser(Object[] retorno) {
		User user = new User();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		user.setId(Integer.parseInt(retorno[0].toString()));
		user.setNome(retorno[3].toString());
		user.setEmail(retorno[2].toString());
		user.setAppId(Integer.parseInt(retorno[6].toString()));
		String data = retorno[1].toString();
		try {
			user.setDataCadastro(sdf.parse(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setDataCadastro(new Date());
		user.setTypeUser(FuncoesEnum.funcaoById(Integer.parseInt(retorno[5].toString())));
		

		return user;
	}

}
