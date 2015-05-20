package edu.mum.mscrum.service;

import java.util.Set;

import edu.mum.mscrum.common.service.GenericService;
import edu.mum.mscrum.model.ProductBacklog;
import edu.mum.mscrum.model.UserStory;

public interface ProductBacklogService extends GenericService<ProductBacklog> {

	public Set<ProductBacklog> searchByTitle(String title);

	public Set<UserStory> getAvailableUserStories(ProductBacklog productBacklog);

}
