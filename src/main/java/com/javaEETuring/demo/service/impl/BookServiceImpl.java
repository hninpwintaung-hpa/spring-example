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
	public void saveBook(Book book) {
		this.bookDao.saveBook(book);		
	}

	@Override
	public void updateBook(Book book) {
        this.bookDao.updateBook(book);		
	}

}
