package edu.mum.mscrum.hrss.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mscrum.hrss.dao.RoleDao;
import edu.mum.mscrum.hrss.model.Role;
import edu.mum.mscrum.hrss.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public Role getRole(Long roleId) {

		return roleDao.getRole(roleId);
	}

	@Override
	public Set<Role> getRoles() {

		return roleDao.getRoles();
	}

}