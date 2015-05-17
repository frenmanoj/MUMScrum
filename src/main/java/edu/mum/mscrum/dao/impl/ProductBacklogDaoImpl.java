package edu.mum.mscrum.dao.impl;

import java.util.Set;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.mum.mscrum.dao.ProductBacklogDao;
import edu.mum.mscrum.model.ProductBacklog;

@Repository
public class ProductBacklogDaoImpl extends GenericHibernateDao<ProductBacklog>
		implements ProductBacklogDao {

	@SuppressWarnings("unchecked")
	@Override
	public Set<ProductBacklog> searchByTitle(String title) {

		return (Set<ProductBacklog>) getSession().createCriteria(ProductBacklog.class)
				.add(Restrictions.eq("title", title)).list();
	}
}
