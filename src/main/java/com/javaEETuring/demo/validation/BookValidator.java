package com.javaEETuring.demo.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javaEETuring.demo.model.Book;

public class BookValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "id", "required.book.id", new Object[] {"id"});
		ValidationUtils.rejectIfEmpty(errors, "author", "required.book.author", new Object[] {"author"});
		ValidationUtils.rejectIfEmpty(errors, "title", "required.book.title", new Object[] {"title"});
	}

}
