package edu.mum.mscrum.dao;

import java.util.List;

import edu.mum.mscrum.model.UserStory;

public interface UserStoryDao extends GenericDao<UserStory> {

	public List<UserStory> searchByTitle(String title);
}
