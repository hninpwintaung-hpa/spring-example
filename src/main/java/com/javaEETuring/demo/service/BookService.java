package com.javaEETuring.demo.service;

import java.util.List;

import com.javaEETuring.demo.model.Book;

public interface BookService {
  List<Book> getAllBook();
  Book getBookById(String id);
  void saveBook(Book book);
  void updateBook(Book book);
}
