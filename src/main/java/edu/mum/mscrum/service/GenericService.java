package edu.mum.mscrum.service;

import java.util.List;

public interface GenericService<T> {

	public T getById(Long id);

	public List<T> listAll();

	public T save(T entity);

	public void delete(T entity);

	public void deleteById(Long id);
}
