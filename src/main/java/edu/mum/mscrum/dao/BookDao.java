package edu.mum.mscrum.dao;

import java.util.List;

import edu.mum.mscrum.model.Book;

public interface BookDao extends GenericDao<Book> {

	public List<Book> searchByName(String name);
}
