package edu.mum.mscrum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.mscrum.dao.ReleaseDao;
import edu.mum.mscrum.model.Release;

@Repository
public class ReleaseDaoImpl extends GenericHibernateDao<Release> implements ReleaseDao {

}
