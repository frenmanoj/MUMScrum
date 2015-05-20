package edu.mum.mscrum.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.mum.mscrum.common.dao.impl.GenericHibernateDao;
import edu.mum.mscrum.dao.ProductBacklogDao;
import edu.mum.mscrum.model.ProductBacklog;
import edu.mum.mscrum.model.UserStory;

@Repository
public class ProductBacklogDaoImpl extends GenericHibernateDao<ProductBacklog>
		implements ProductBacklogDao {

	@SuppressWarnings("unchecked")
	@Override
	public Set<ProductBacklog> searchByTitle(String title) {

		return (Set<ProductBacklog>) getSession()
				.createCriteria(ProductBacklog.class)
				.add(Restrictions.eq("title", title)).list();
	}

	@Override
	public Set<UserStory> getAvailableUserStories(ProductBacklog productBacklog) {

		Set<UserStory> userStories = productBacklog.getUserStories();

		Set<UserStory> availableUserStories = new HashSet<UserStory>();

		for (UserStory userStory : userStories) {

			if (userStory.getReleaseBacklog() == null) {

				availableUserStories.add(userStory);
			}
		}

		return availableUserStories;
	}
}
