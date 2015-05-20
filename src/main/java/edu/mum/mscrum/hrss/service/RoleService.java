package edu.mum.mscrum.hrss.service;

import java.util.Set;

import edu.mum.mscrum.hrss.model.Role;

public interface RoleService {

	public Role getRole(Long roleId);

	public Set<Role> getRoles();

}