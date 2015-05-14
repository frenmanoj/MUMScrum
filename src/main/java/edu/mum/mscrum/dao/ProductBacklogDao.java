package edu.mum.mscrum.dao;

import java.util.List;

import edu.mum.mscrum.model.ProductBacklog;

public interface ProductBacklogDao extends GenericDao<ProductBacklog> {

	public List<ProductBacklog> searchByTitle(String title);
}
