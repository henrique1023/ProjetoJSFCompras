package br.com.dio.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoFactory {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancocompras");
	
	public static UserDaoHibernate createUserDao() {
		return new UserDaoHibernate(emf);
	}

}
