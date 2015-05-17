package edu.mum.mscrum.service;

import java.util.Set;

import edu.mum.mscrum.model.Book;

public interface BookService extends GenericService<Book> {

	public Set<Book> searchByName(String name);

}
