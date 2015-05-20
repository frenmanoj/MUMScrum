package edu.mum.mscrum.hrss.service;

import java.util.Set;

import edu.mum.mscrum.common.service.GenericService;
import edu.mum.mscrum.hrss.model.Employee;

public interface EmployeeService extends GenericService<Employee> {

	public Set<Employee> getEmployee(Long id);

}
