package edu.mum.mscrum.hrss.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mscrum.hrss.dao.EmployeeDao;
import edu.mum.mscrum.hrss.model.Employee;
import edu.mum.mscrum.hrss.service.EmployeeService;
import edu.mum.mscrum.service.impl.GenericServiceImpl;

@Service
@Transactional
public class EmployeeServiceImpl extends
		GenericServiceImpl<Employee> implements EmployeeService {

	private EmployeeDao employeeDao;

	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {

		super(employeeDao);

		this.employeeDao = (EmployeeDao) employeeDao;
	}

	@Override
	public Set<Employee> getEmployee(Long id) {

		return (Set<Employee>) employeeDao.listAll();
	}
}
