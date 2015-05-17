package edu.mum.mscrum.hrss.dao;

import java.util.Set;

import edu.mum.mscrum.dao.GenericDao;
import edu.mum.mscrum.hrss.model.Employee;
import edu.mum.mscrum.model.ProductBacklog;

public interface EmployeeDao extends GenericDao<Employee>{

	public Set<Employee> getEmployee(Long id);

}