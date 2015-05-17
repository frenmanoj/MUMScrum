package edu.mum.mscrum.hrss.service;

import java.util.Set;

import edu.mum.mscrum.hrss.model.Employee;
import edu.mum.mscrum.service.GenericService;

public interface EmployeeService extends GenericService<Employee> {

	public Set<Employee> getEmployee(Long id);

}
