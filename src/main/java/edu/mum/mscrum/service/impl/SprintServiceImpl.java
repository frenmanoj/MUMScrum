package edu.mum.mscrum.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mscrum.common.service.impl.GenericServiceImpl;
import edu.mum.mscrum.dao.SprintDao;
import edu.mum.mscrum.model.Sprint;
import edu.mum.mscrum.service.SprintService;

@Service
@Transactional
public class SprintServiceImpl extends
		GenericServiceImpl<Sprint> implements SprintService {

	private SprintDao productBacklogDao;

	public SprintServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public SprintServiceImpl(SprintDao productBacklogDao) {

		super(productBacklogDao);

		this.productBacklogDao = (SprintDao) productBacklogDao;
	}

	@Override
	public Set<Sprint> searchByTitle(String title) {

		return (Set<Sprint>) productBacklogDao.listAll();
	}
}
