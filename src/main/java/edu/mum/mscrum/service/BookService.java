package edu.mum.mscrum.service;

import java.util.List;

import edu.mum.mscrum.model.Book;

public interface BookService extends GenericService<Book> {

	public List<Book> searchByName(String name);

}
