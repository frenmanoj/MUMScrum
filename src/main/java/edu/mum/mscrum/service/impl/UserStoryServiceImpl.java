package edu.mum.mscrum.service.impl;

import java.util.Set;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mscrum.common.service.impl.GenericServiceImpl;
import edu.mum.mscrum.dao.UserStoryDao;
import edu.mum.mscrum.model.UserStory;
import edu.mum.mscrum.service.UserStoryService;

@Service
@Transactional
public class UserStoryServiceImpl extends GenericServiceImpl<UserStory>
		implements UserStoryService {

	private UserStoryDao userStoryDao;

	public UserStoryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserStoryServiceImpl(UserStoryDao userStoryDao) {

		super(userStoryDao);

		this.userStoryDao = (UserStoryDao) userStoryDao;
	}

	@Override
	public Set<UserStory> searchByTitle(String title) {

		return userStoryDao.listAll();
	}
}
