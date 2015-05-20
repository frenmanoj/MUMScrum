package edu.mum.mscrum.service;

import java.util.Set;

import edu.mum.mscrum.common.service.GenericService;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.UserStory;

public interface ReleaseService extends GenericService<Release> {

	Set<UserStory> getAvailableUserStories(Release release);

}
