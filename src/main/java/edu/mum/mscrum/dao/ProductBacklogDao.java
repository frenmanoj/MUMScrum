package edu.mum.mscrum.dao;

import java.util.Set;

import edu.mum.mscrum.model.ProductBacklog;
import edu.mum.mscrum.model.UserStory;

public interface ProductBacklogDao extends GenericDao<ProductBacklog> {

	public Set<ProductBacklog> searchByTitle(String title);

	public Set<UserStory> getAvailableUserStories(ProductBacklog productBacklog);
}
