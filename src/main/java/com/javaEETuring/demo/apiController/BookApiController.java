package com.javaEETuring.demo.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaEETuring.demo.apiController.error.ApiErrorResponse;
import com.javaEETuring.demo.model.Book;
import com.javaEETuring.demo.service.BookService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookApiController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	 List<Book> getAllBook(){
		log.info("Get All Book");
		return this.bookService.getAllBook();
	}
	@GetMapping("/{bookId}")
	ResponseEntity<Object> getBookById(@PathVariable String bookId) {
		log.info("Book by id");
		Book book =  null;
		try {
			book =  this.bookService.getBookById(bookId);
			return ResponseEntity.ok(book);

		}catch(Exception e) {
			log.error("getBookById " + e.getMessage());
			ApiErrorResponse error = new ApiErrorResponse("1001", "No such book");
			return ResponseEntity.badRequest().body(error);
		}
		//return book;
	}
	
	@PostMapping
	ResponseEntity<Object> saveBook(@RequestBody @Valid Book book, BindingResult result) {
		
		if(result.hasErrors()) {
			log.info("Validation error");
			return ResponseEntity.badRequest().body(result.getAllErrors());
		}else {
			log.info("Save book api " + book);
			Book savedBook = this.bookService.saveBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);

		}
	}

}
