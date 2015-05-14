package edu.mum.mscrum.service;

import java.util.List;

import edu.mum.mscrum.model.UserStory;

public interface UserStoryService extends GenericService<UserStory> {

	public List<UserStory> searchByTitle(String title);

}
