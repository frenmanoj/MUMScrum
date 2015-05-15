package edu.mum.mscrum.hrss.dao;

import edu.mum.mscrum.hrss.model.User;

public interface UserDao {

	public User getUser(String username);

}