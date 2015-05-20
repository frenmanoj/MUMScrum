package edu.mum.mscrum.service;

import java.util.List;
import java.util.Set;

import edu.mum.mscrum.common.service.GenericService;
import edu.mum.mscrum.model.UserStory;

public interface UserStoryService extends GenericService<UserStory> {

	public Set<UserStory> searchByTitle(String title);

}
