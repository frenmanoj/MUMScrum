package edu.mum.mscrum.dao.impl;

import java.util.Set;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.mum.mscrum.common.dao.impl.GenericHibernateDao;
import edu.mum.mscrum.dao.ProductBacklogDao;
import edu.mum.mscrum.dao.SprintDao;
import edu.mum.mscrum.model.ProductBacklog;
import edu.mum.mscrum.model.Sprint;

@Repository
public class SprintDaoImpl extends GenericHibernateDao<Sprint>
		implements SprintDao {

	@SuppressWarnings("unchecked")
	@Override
	public Set<Sprint> searchByTitle(String title) {

		return (Set<Sprint>) getSession().createCriteria(Sprint.class)
				.add(Restrictions.eq("title", title)).list();
	}
}
