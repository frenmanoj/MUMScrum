package edu.mum.mscrum.service;

import java.util.List;
import java.util.Set;

import edu.mum.mscrum.common.service.GenericService;
import edu.mum.mscrum.model.Sprint;

public interface SprintService extends GenericService<Sprint> {

	public Set<Sprint> searchByTitle(String title);

}
