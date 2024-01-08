package com.javaspring.renderingallbooks.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaspring.renderingallbooks.models.Book;
import com.javaspring.renderingallbooks.services.BookService;


@Controller
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService =  bookService;
	}
	
	@RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "home.jsp";
    }
	
	@RequestMapping("/books/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Book thisBook = bookService.findBook(id);
		model.addAttribute("thisBook", thisBook);
		return "show.jsp";
	}
}
