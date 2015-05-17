package edu.mum.mscrum.service;

import java.util.List;
import java.util.Set;

import edu.mum.mscrum.model.ProductBacklog;

public interface ProductBacklogService extends GenericService<ProductBacklog> {

	public Set<ProductBacklog> searchByTitle(String title);

}
