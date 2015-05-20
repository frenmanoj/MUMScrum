package edu.mum.mscrum.dao;

import java.util.Set;

import edu.mum.mscrum.common.dao.GenericDao;
import edu.mum.mscrum.model.ProductBacklog;
import edu.mum.mscrum.model.Sprint;

public interface SprintDao extends GenericDao<Sprint> {

	public Set<Sprint> searchByTitle(String title);
}
