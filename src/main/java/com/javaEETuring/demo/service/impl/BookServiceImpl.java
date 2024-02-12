package com.javaEETuring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaEETuring.demo.dao.BookDAO;
import com.javaEETuring.demo.model.Book;
import com.javaEETuring.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDAO bookDao;
	@Override
	public List<Book> getAllBook() {
		return this.bookDao.getAllBook();
	}

	@Override
	public Book getBookById(String id) {
		return this.bookDao.getBookById(id);
	}

	@Override
	public Book saveBook(Book book) {
		return this.bookDao.saveBook(book);		
	}

	@Override
	public Book updateBook(Book book) {
        return this.bookDao.updateBook(book);		
	}

	@Override
	public void deleteBook(String id) {
		this.bookDao.deleteBook(id);		
	}
	

}
