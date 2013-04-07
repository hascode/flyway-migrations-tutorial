package it;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hascode.entity.Book;

public class BookIT {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;

	@Before
	public void initEntityManager() throws Exception {
		emf = Persistence.createEntityManagerFactory("hascode-manual");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	@After
	public void closeEntityManager() throws SQLException {
		em.close();
		emf.close();
	}

	@Test
	public void booksShouldExist() throws Exception {
		Book book = em.createQuery(
				"SELECT b FROM Book b WHERE b.title = 'The third book'",
				Book.class).getSingleResult();
		assertNotNull(book);
	}
}
