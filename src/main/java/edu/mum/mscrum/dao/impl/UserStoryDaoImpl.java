package edu.mum.mscrum.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.mum.mscrum.dao.UserStoryDao;
import edu.mum.mscrum.model.UserStory;

@Repository
public class UserStoryDaoImpl extends GenericHibernateDao<UserStory> implements
		UserStoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserStory> searchByTitle(String title) {

		return getSession().createCriteria(UserStory.class)
				.add(Restrictions.eq("title", title)).list();
	}
}
