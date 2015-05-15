package edu.mum.mscrum.hrss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mscrum.hrss.dao.UserDao;
import edu.mum.mscrum.hrss.model.User;
import edu.mum.mscrum.hrss.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User getUser(String login) {
		return userDao.getUser(login);
	}

}