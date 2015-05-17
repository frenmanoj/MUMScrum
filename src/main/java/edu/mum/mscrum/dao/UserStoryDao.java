package edu.mum.mscrum.dao;

import java.util.Set;

import edu.mum.mscrum.model.UserStory;

public interface UserStoryDao extends GenericDao<UserStory> {

	public Set<UserStory> searchByTitle(String title);
}
