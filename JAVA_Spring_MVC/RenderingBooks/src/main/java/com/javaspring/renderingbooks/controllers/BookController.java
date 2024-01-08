package com.javaspring.renderingbooks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaspring.renderingbooks.models.Book;
import com.javaspring.renderingbooks.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService =  bookService;
	}
	
	@RequestMapping("/books/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Book thisBook = bookService.findBook(id);
		model.addAttribute("thisBook", thisBook);
		return "show.jsp";
	}
}
