package edu.mum.mscrum.hrss.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.mscrum.hrss.dao.RoleDao;
import edu.mum.mscrum.hrss.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Role getRole(Long id) {

		Role role = (Role) getCurrentSession().load(Role.class, id);

		return role;
	}
}