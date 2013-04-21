package com.hascode.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

import com.hascode.entity.Book;

@Stateless
public class BookEJB implements BookService {
	@PersistenceUnit(unitName = "hascode-jta-unit")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see com.hascode.ejb.BookService#findAll()
	 */
	@Override
	public List<Book> findAll() {
		List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class)
				.getResultList();
		if (books == null)
			books = new ArrayList<Book>();
		return books;
	}
}
