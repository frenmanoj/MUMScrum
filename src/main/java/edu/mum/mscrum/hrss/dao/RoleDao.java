package edu.mum.mscrum.hrss.dao;

import java.util.Set;

import edu.mum.mscrum.hrss.model.Role;

public interface RoleDao {

	public Role getRole(Long id);

	public Set<Role> getRoles();
}
