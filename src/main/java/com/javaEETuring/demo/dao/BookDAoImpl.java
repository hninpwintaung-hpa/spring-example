package com.javaEETuring.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaEETuring.demo.model.Book;

@Repository
public class BookDAoImpl implements BookDAO {

	List<Book> book;

	BookDAoImpl() {
		this.book = new ArrayList<Book>();
		this.book.add(new Book("1", "Title 1", "Author 1"));
		this.book.add(new Book("2", "Title 2", "Author 2"));
		this.book.add(new Book("3", "Title 3", "Author 3"));

	}

	@Override
	public List<Book> getAllBook() {
		return this.book;
	}

	@Override
	public Book getBookById(String id) {
		return this.book.stream().filter(book -> book.getId().equals(id)).collect(Collectors.toList()).get(0);
	}

	@Override
	public Book saveBook(Book book) {
		this.book.add(book);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		Book originBook = this.getBookById(book.getId());
		originBook.setTitle( book.getTitle());
		originBook.setAuthor(book.getAuthor());
		return book;
	}

	@Override
	public void deleteBook(String id) {
		List<Book> books = this.book.stream().filter(book->!book.getId().equals(id)).collect(Collectors.toList());
		this.book = books;
	}

}
