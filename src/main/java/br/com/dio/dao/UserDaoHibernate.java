package br.com.dio.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
		obj.setDataCadastro(new Date());
		password = UserUtil.convertStringToMd5(password);
		obj.setSenha(password);
		entityManager.persist(obj);
		transaction.commit();
	}

	@Override
	public void update(User obj) {
		// TODO Auto-generated method stub

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

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void gerarNovaSenha(String login, String email) {

	}

	// Verifica se usuário existe ou se pode logar
	public User isUserReadyToLogin(String email, String senha) {
		email = email.toLowerCase().trim();
		StringBuffer sql = new StringBuffer();
		String password = UserUtil.convertStringToMd5(senha);
		sql.append("SELECT * FROM tb_user c ");
		sql.append("WHERE c.email = '" + email + "' AND c.senha = '" + password + "'");
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		user.setId(Integer.parseInt(retorno[0].toString()));
		user.setNome(retorno[3].toString());
		user.setEmail(retorno[2].toString());
		user.setSenha(retorno[4].toString());
//		String data = retorno[1].toString();
//		data = data.substring(0, 19).replace('-', '/');
		// user.setDataCadastro(sdf.parse(data));
		user.setDataCadastro(new Date());
		user.setTypeUser(retorno[5].toString().charAt(0));

		return user;
	}

}
