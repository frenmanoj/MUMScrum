package edu.mum.mscrum.common.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.mscrum.common.dao.GenericDao;

@SuppressWarnings("unchecked")
public class GenericHibernateDao<T> implements GenericDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> persistentClass;

	public GenericHibernateDao() {

		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T getById(Long id) {

		return (T) getSession().get(getPersistentClass(), id);
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

	public Class<T> getPersistentClass() {

		return persistentClass;
	}

	@Override
	public Set<T> listAll() {

		List<T> list = getSession().createCriteria(getPersistentClass())
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		Set<T> returnList = new HashSet<T>();

		for (T t : list) {
			returnList.add(t);
		}

		return returnList;
	}

	@Override
	public T save(T entity) {

		return (T) getSession().merge(entity);
	}

	@Override
	public void delete(T entity) {

		getSession().delete(entity);
	}

	@Override
	public void deleteById(Long id) {

		T entity = getById(id);

		delete(entity);
	}

	@Override
	public void update(T entity) {

		getSession().update(entity);

	}
}
