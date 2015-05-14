package edu.mum.mscrum.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.mum.mscrum.dao.ProductBacklogDao;
import edu.mum.mscrum.model.ProductBacklog;

@Repository
public class ProductBacklogDaoImpl extends GenericHibernateDao<ProductBacklog>
		implements ProductBacklogDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBacklog> searchByTitle(String title) {

		return getSession().createCriteria(ProductBacklog.class)
				.add(Restrictions.eq("title", title)).list();
	}
}
