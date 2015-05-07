package edu.mum.mscrum.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.mum.mscrum.dao.BookDao;
import edu.mum.mscrum.model.Book;

@Repository
public class BookDaoImpl extends GenericHibernateDao<Book> implements BookDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchByName(String name) {

		return getSession().createCriteria(Book.class)
				.add(Restrictions.eq("name", name)).list();
	}
}
