package edu.mum.mscrum.dao.impl;


import org.springframework.stereotype.Repository;

import edu.mum.mscrum.common.dao.impl.GenericHibernateDao;
import edu.mum.mscrum.dao.BurndownDao;
import edu.mum.mscrum.model.Burndown;



@Repository
public class BurndownDaoImpl extends GenericHibernateDao<Burndown> implements
BurndownDao{

}
