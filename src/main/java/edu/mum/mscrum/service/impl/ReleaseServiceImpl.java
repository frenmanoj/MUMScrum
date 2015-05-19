package edu.mum.mscrum.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mscrum.dao.ReleaseDao;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.UserStory;
import edu.mum.mscrum.service.ReleaseService;

@Service
public class ReleaseServiceImpl extends GenericServiceImpl<Release> implements
		ReleaseService {

	@Autowired
	private ReleaseDao releaseDao;

	public ReleaseServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public ReleaseServiceImpl(ReleaseDao releaseDao) {

		super(releaseDao);

		this.releaseDao = (ReleaseDao) releaseDao;
	}

	@Override
	public Set<UserStory> getAvailableUserStories(Release release) {

		return releaseDao.getAvailableUserStories(release);
	}

}
