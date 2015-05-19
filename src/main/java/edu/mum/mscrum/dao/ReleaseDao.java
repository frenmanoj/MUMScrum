package edu.mum.mscrum.dao;

import java.util.Set;

import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.UserStory;

public interface ReleaseDao extends GenericDao<Release> {

	Set<UserStory> getAvailableUserStories(Release release);

}
