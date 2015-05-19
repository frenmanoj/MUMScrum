package edu.mum.mscrum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mscrum.dao.ViewBurndownDao;
import edu.mum.mscrum.model.ViewBurndown;
import edu.mum.mscrum.service.ViewBurndownService;

@Service
@Transactional
public class ViewBurndownServiceImpl extends GenericServiceImpl<ViewBurndown> implements ViewBurndownService {
	
	private ViewBurndownDao viewBurndownDao;
	
	public ViewBurndownServiceImpl()
	{
		
	}
	
	@Autowired
	
	public ViewBurndownServiceImpl(ViewBurndownDao viewBurndownDao)
	{
		super(viewBurndownDao);
		
		this.viewBurndownDao= (ViewBurndownDao) viewBurndownDao;
		
	}

}
