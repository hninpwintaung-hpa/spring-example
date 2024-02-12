package com.javaEETuring.demo.service;

import java.util.List;

import com.javaEETuring.demo.model.Book;

public interface BookService {
  List<Book> getAllBook();
  Book getBookById(String id);
  Book saveBook(Book book);
  Book updateBook(Book book);
  void deleteBook(String id);
}
