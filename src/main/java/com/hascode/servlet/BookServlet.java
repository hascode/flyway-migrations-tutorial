package com.hascode.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hascode.ejb.BookService;
import com.hascode.entity.Book;

@WebServlet(name = "bookServlet", urlPatterns = "/books", loadOnStartup = 1)
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private BookService bookEJB;

	@Override
	protected void doGet(final HttpServletRequest req,
			final HttpServletResponse resp) throws ServletException,
			IOException {
		List<Book> books = bookEJB.findAll();
		if (books.isEmpty()) {
			resp.getWriter().append("no books");
			return;
		}

		resp.getWriter().append(
				books.size() + " books:\n---------------------------------\n");
		for (Book book : books) {
			resp.getWriter().append("- " + book.getTitle() + "\n");
		}
	}
}
