package edu.mum.mscrum.common.dao;

import java.util.List;
import java.util.Set;

public interface GenericDao<T> {

	public T getById(Long id);

	public Set<T> listAll();

	public T save(T entity);

	public void delete(T entity);

	public void deleteById(Long id);
	
	public void update( T entity);
}
