package edu.mum.mscrum.dao;

import java.util.List;

public interface GenericDao<T> {

	public T getById(Long id);

	public List<T> listAll();

	public T save(T entity);

	public void delete(T entity);

	public void deleteById(Long id);
}
