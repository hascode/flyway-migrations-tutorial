package com.hascode.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hascode.entity.Book;

@Stateless
public class BookEJB implements BookService {
	@PersistenceContext(unitName = "hascode-jta-unit")
	private EntityManager em;

	@Override
	public List<Book> findAll() {
		List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class)
				.getResultList();
		if (books == null)
			books = new ArrayList<>();
		return books;
	}
}
