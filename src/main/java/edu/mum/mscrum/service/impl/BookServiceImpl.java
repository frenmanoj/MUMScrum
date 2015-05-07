package edu.mum.mscrum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mscrum.dao.BookDao;
import edu.mum.mscrum.dao.GenericDao;
import edu.mum.mscrum.model.Book;
import edu.mum.mscrum.service.BookService;

@Service
public class BookServiceImpl extends GenericServiceImpl<Book> implements
		BookService {

	private BookDao bookDao;

	@Autowired
	public BookServiceImpl(GenericDao<Book> genericDao) {

		super(genericDao);

		this.bookDao = (BookDao) genericDao;
	}

	@Override
	public List<Book> searchByName(String name) {

		return bookDao.listAll();
	}
}
