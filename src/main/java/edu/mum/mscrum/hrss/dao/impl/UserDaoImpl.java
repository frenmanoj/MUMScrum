package edu.mum.mscrum.hrss.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.mscrum.hrss.dao.UserDao;
import edu.mum.mscrum.hrss.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {

		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public User getUser(String username) {

		Query query = openSession().createQuery(
				"from User u where u.username = :username");
		query.setParameter("username", username);

		List<User> userList = query.list();

		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

}