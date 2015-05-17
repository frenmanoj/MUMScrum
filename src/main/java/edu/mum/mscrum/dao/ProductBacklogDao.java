package edu.mum.mscrum.dao;

import java.util.Set;

import edu.mum.mscrum.model.ProductBacklog;

public interface ProductBacklogDao extends GenericDao<ProductBacklog> {

	public Set<ProductBacklog> searchByTitle(String title);
}
