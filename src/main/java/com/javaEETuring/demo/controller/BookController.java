package com.javaEETuring.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.javaEETuring.demo.model.Book;
import com.javaEETuring.demo.service.BookService;
import com.javaEETuring.demo.validation.BookValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new BookValidator());
	}
	
	@GetMapping("/new")
	String BookForm(Model model) {
		Book book = new Book();
		//book.setId("one");
		model.addAttribute("book", book);
		return "books/newBook";
	}
	
	@PostMapping("/newBook")
	String CreateBook(@Valid @ModelAttribute Book book, BindingResult result) {
		if(result.hasErrors()) {
			log.info("Book has error!");
			return "books/newBook";
		}else {
			this.bookService.saveBook(book);
			return "redirect:/books/new";

		}
	}
	
	@PostMapping("/update/{id}")
	String updateBook(@Valid @ModelAttribute Book book,BindingResult result) {
		if(result.hasErrors()) {
			log.info("Update book has error!");
			return "books/editBook";
		}else {
			this.bookService.updateBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping
	String getAllBook(Model model) {
		List<Book> books = this.bookService.getAllBook();
		for(Book book: books) {
			log.info("book " + book);
		}
		model.addAttribute("books",books);
		return "books/book";
	}
	
	@GetMapping("/{id}")
	String getBookById(Model model,@PathVariable String id) {
		Book book = this.bookService.getBookById(id);
		List<Book> books = new ArrayList<Book>();
		books.add(book);
		model.addAttribute("books", books);
		return "books/book";
	}
	
	@GetMapping("/edit/{id}")
	String BookForm(Model model,@PathVariable String id) {
		log.info("edit id :" + id);
		Book book = this.bookService.getBookById(id);
		log.info("Book" + book);
		model.addAttribute("book", book);
		return "books/editBook";
	}
	
	@GetMapping("/session")
	String session(HttpSession session,
			Principal user,
			@CookieValue("JSESSIONID") String sessionId
			)
	//,@RequestHeader("Accept_Encoding") String encoding
	{
		
		log.info("sessionid " + sessionId);
		//log.info("Encoding " + encoding);
		log.info("Authenticated user " + user);
		session.setAttribute("message", "Put by ssession");
		return "home";
	}
	
	@GetMapping("/getSession")
	String getSession(@SessionAttribute String message,Model model, HttpSession session) {
		log.info("session attribute " + message);
		model.addAttribute("message", session.getAttribute("message"));
		return "home";
	}
}
