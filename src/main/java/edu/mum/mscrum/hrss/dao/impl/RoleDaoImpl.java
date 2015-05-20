package edu.mum.mscrum.hrss.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@SuppressWarnings("unchecked")
	@Override
	public Set<Role> getRoles() {

		List<Role> roles = getCurrentSession().createCriteria(Role.class)
				.list();

		Set<Role> roleSet = new HashSet<Role>();

		for (Role role : roles) {
			roleSet.add(role);
		}

		return roleSet;
	}
}