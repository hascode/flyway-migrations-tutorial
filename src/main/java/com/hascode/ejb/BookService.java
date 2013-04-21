package com.hascode.ejb;

import java.util.List;

import com.hascode.entity.Book;

public interface BookService {

	public abstract List<Book> findAll();

}