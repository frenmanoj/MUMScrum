package edu.mum.mscrum.hrss.subsystem.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.mscrum.hrss.model.Employee;
import edu.mum.mscrum.hrss.subsystem.dao.IHRSubsystemDao;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.UserStory;

public class HRSubsystemFacade implements IHRSubsystem {

	@Autowired
	private IHRSubsystemDao subsystemDao;

	@Override
	public void assignDeveloperToUserStory(UserStory userStory,
			Employee developer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignTesterToUserStory(UserStory userStory, Employee tester) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignScrumMasterToRelease(Release release, Employee scrumMaster) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Employee> getDevelopersList() {

		return subsystemDao.getDevelopersList();
	}

	@Override
	public Set<Employee> getTestersList() {
		// TODO Auto-generated method stub
		return null;
	}

}
