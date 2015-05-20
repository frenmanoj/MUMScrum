package edu.mum.mscrum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mscrum.common.service.impl.GenericServiceImpl;
import edu.mum.mscrum.dao.BurndownDao;
import edu.mum.mscrum.model.Burndown;
import edu.mum.mscrum.service.BurndownService;

@Service
@Transactional
public class BurndownServiceImpl extends GenericServiceImpl<Burndown> implements BurndownService {
	
	private BurndownDao burndownDao;
	
	public BurndownServiceImpl()
	{
		
	}
	
	@Autowired
	
	public BurndownServiceImpl(BurndownDao burndownDao)
	{
		super(burndownDao);
		
		this.burndownDao= (BurndownDao) burndownDao;
		
	}

}
