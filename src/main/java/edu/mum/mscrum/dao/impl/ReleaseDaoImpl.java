package edu.mum.mscrum.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import edu.mum.mscrum.common.dao.impl.GenericHibernateDao;
import edu.mum.mscrum.dao.ReleaseDao;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.UserStory;

@Repository
public class ReleaseDaoImpl extends GenericHibernateDao<Release> implements
		ReleaseDao {

	@Override
	public Set<UserStory> getAvailableUserStories(Release release) {

		Set<UserStory> userStories = release.getUserStories();

		Set<UserStory> availableUserStories = new HashSet<UserStory>();

		for (UserStory userStory : userStories) {

			if (userStory.getSprint() == null) {

				availableUserStories.add(userStory);
			}
		}

		return availableUserStories;
	}

}
