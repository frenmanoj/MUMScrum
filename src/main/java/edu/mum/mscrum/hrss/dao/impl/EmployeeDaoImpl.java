package edu.mum.mscrum.hrss.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.mscrum.dao.impl.GenericHibernateDao;
import edu.mum.mscrum.hrss.dao.EmployeeDao;
import edu.mum.mscrum.hrss.model.Employee;

@Repository
public class EmployeeDaoImpl extends GenericHibernateDao<Employee>
		implements EmployeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployee(Long id) {

		return getSession().createCriteria(Employee.class)
				.add(Restrictions.eq("id", id)).list();
	}
}