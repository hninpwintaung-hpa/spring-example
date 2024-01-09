package com.javaEETuring.demo.dao;

import java.util.List;

import com.javaEETuring.demo.model.Book;

public interface BookDAO {
	  List<Book> getAllBook();
	  Book getBookById(String id);
	  void saveBook(Book book);
	  void updateBook(Book book);

}
