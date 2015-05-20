package edu.mum.mscrum.hrss.subsystem;

import java.util.List;

import edu.mum.mscrum.hrss.model.Employee;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.UserStory;

public class HRSubsystemFacade implements IHRSubsystem {

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
	public List<Employee> getDevelopersList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getTestersList() {
		// TODO Auto-generated method stub
		return null;
	}

}
