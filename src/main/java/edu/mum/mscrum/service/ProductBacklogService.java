package edu.mum.mscrum.service;

import java.util.List;

import edu.mum.mscrum.model.ProductBacklog;

public interface ProductBacklogService extends GenericService<ProductBacklog> {

	public List<ProductBacklog> searchByTitle(String title);

}
