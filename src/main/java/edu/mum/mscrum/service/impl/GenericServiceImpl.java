package edu.mum.mscrum.service.impl;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import edu.mum.mscrum.dao.GenericDao;
import edu.mum.mscrum.service.GenericService;

@Transactional
public abstract class GenericServiceImpl<T> implements GenericService<T> {

	private GenericDao<T> genericDao;

	public GenericServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public GenericServiceImpl(GenericDao<T> genericDao) {

		this.genericDao = genericDao;
	}

	@Override
	public T getById(Long id) {
		return genericDao.getById(id);
	}

	@Override
	public Set<T> listAll() {

		return genericDao.listAll();
	}

	@Override
	public T save(T entity) {

		return genericDao.save(entity);
	}

	@Override
	public void delete(T entity) {

		genericDao.delete(entity);
	}

	@Override
	public void deleteById(Long id) {

		genericDao.deleteById(id);
	}
}
