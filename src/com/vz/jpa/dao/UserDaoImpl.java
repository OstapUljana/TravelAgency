package com.vz.jpa.dao;

import com.vz.jpa.daoInterfaces.UserDao;
import com.vz.jpa.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Женя on 16.07.2014.
 */
public class UserDaoImpl implements UserDao {

	private static EntityManagerFactory entityManagerFactory = HibernateUtil
			.buildEntityManagerFactory();

	@Override
	public List<User> selectAll() {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		// Query query =
		// entityManager.createQuery("SELECT iduser, login, pass FROM travelagency.user");
		// List<User> users = query.getResultList();
		List<User> users = new ArrayList<User>(); // NEEED DELETE THIS
		entityManager.close();
		return users;
	}

	public User selectUser(String login, String pass) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		try {
			Query query = entityManager
					.createQuery("SELECT u FROM User u WHERE u.login=:logiin and u.pass=:passs");
			query.setParameter("logiin", login);
			query.setParameter("passs", pass);
			User result = (User) query.getSingleResult();
			return result;
		} catch (javax.persistence.NoResultException e) {
			User result = new User();
			return result;
		}

	}

	@Override
	public User selectById(int id) {
		return null;
	}

	@Override
	public int update(User user) {
		return 0;
	}

	@Override
	public int insert(User user) {
		return 0;
	}

}
