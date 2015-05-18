package edu.mum.mscrum.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mscrum.dao.ProductBacklogDao;
import edu.mum.mscrum.model.ProductBacklog;
import edu.mum.mscrum.model.UserStory;
import edu.mum.mscrum.service.ProductBacklogService;

@Service
@Transactional
public class ProductBacklogServiceImpl extends
		GenericServiceImpl<ProductBacklog> implements ProductBacklogService {

	private ProductBacklogDao productBacklogDao;

	public ProductBacklogServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public ProductBacklogServiceImpl(ProductBacklogDao productBacklogDao) {

		super(productBacklogDao);

		this.productBacklogDao = (ProductBacklogDao) productBacklogDao;
	}

	@Override
	public Set<ProductBacklog> searchByTitle(String title) {

		return (Set<ProductBacklog>) productBacklogDao.listAll();
	}

	@Override
	public Set<UserStory> getAvailableUserStories(ProductBacklog productBacklog) {

		return productBacklogDao.getAvailableUserStories(productBacklog);
	}
}
