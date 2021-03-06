package edu.mum.mscrum.hrss.subsystem.service;

import java.util.Set;

import edu.mum.mscrum.hrss.model.Employee;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.UserStory;

public interface IHRSubsystem {

	public void assignDeveloperToUserStory(UserStory userStory,
			Employee developer);

	public void assignTesterToUserStory(UserStory userStory, Employee tester);

	public void assignScrumMasterToRelease(Release release, Employee scrumMaster);

	public Set<Employee> getDevelopersList();

	public Set<Employee> getTestersList();

}
