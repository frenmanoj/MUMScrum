package edu.mum.mscrum.service;

import java.util.List;
import java.util.Set;

public interface GenericService<T> {

	public T getById(Long id);

	public Set<T> listAll();

	public T save(T entity);

	public void delete(T entity);

	public void deleteById(Long id);
}
