package edu.mum.mscrum.hrss.subsystem.dao;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.mscrum.hrss.model.Employee;
import edu.mum.mscrum.model.Release;
import edu.mum.mscrum.model.UserStory;

public class HRSubsystemDaoImpl implements IHRSubsystemDao {

	@Autowired
	private SessionFactory sessionFactory;

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

	@SuppressWarnings("rawtypes")
	@Override
	public Set<Employee> getDevelopersList() {

		Query query = getSession()
				.createSQLQuery(
						"select e.id from employee e, user u, employee_user eu, role r, user_role ur where e.id = eu.employee_id and u.id = eu.user_id and u.id = ur.user_id and r.id = ur.role_id and r.role = :role")
				.setParameter("role", "ROLE_DEVELOPER");

		List result = query.list();

		Set<Employee> employeeList = new HashSet<Employee>();
		for (Object id : result) {

			BigInteger employeeId = (BigInteger) id;

			System.out.println(id);
			Employee employee = (Employee) getSession().load(Employee.class,
					Long.valueOf(employeeId.toString()));

			employeeList.add(employee);
		}

		return employeeList;
	}

	@Override
	public Set<Employee> getTestersList() {
		// TODO Auto-generated method stub
		return null;
	}

	protected Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {

		return sessionFactory;
	}

}
