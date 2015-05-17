package edu.mum.mscrum.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mscrum.dao.BookDao;
import edu.mum.mscrum.model.Book;
import edu.mum.mscrum.service.BookService;

@Service
@Transactional
public class BookServiceImpl extends GenericServiceImpl<Book> implements
		BookService {

	private BookDao bookDao;

	public BookServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public BookServiceImpl(BookDao bookDao) {

		super(bookDao);

		this.bookDao = (BookDao) bookDao;
	}

	@Override
	public Set<Book> searchByName(String name) {

		return bookDao.listAll();
	}
}
