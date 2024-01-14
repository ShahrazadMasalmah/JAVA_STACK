package com.javaspring.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.javaspring.bookclub.models.Book;
import com.javaspring.bookclub.models.LoginUser;
import com.javaspring.bookclub.models.User;
import com.javaspring.bookclub.services.BookService;
import com.javaspring.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserBookController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String showLogin(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User registeredUser = userService.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		else {
			session.setAttribute("userId", registeredUser.getId());
			return "redirect:/books";
		}
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User loginUser = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		else {
			session.setAttribute("userId", loginUser.getId());
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books")
	public String homePage(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/";
		}
		else {
			User thisUser = userService.findUser(userId);
			model.addAttribute("user", thisUser);
			model.addAttribute("books", bookService.allBooks());
			return "books.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/books/new")
	public String addBook(@ModelAttribute("book") Book book, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/";
		}
		
		return "addBook.jsp";
	}
	
	@PostMapping("/add/book")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()) {
			return "addBook.jsp";
		}
		else {
			Long userId = (Long) session.getAttribute("userId");
			User thisUser = userService.findUser(userId);
			book.setUser(thisUser);
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/{bookId}")
	public String viewBook(@PathVariable("bookId") Long bookId, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/";
		}
		else {
			Book thisBook = bookService.findBook(bookId);
			User thisUser = userService.findUser(userId);
			model.addAttribute("book", thisBook);
			model.addAttribute("user", thisUser);
			return "ViewBook.jsp";
		}
		
	}
	
	@GetMapping("/books/{bookId}/edit")
	public String editBook(@PathVariable("bookId") Long bookId, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/";
		}
		else {
			Book thisBook = bookService.findBook(bookId);
	        model.addAttribute("book", thisBook);
	        return "editBook.jsp";
		}
		
	}
	
	@PutMapping("/books/{bookId}")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session,
			@PathVariable("bookId") Long bookId) {
		if(result.hasErrors()) {
			model.addAttribute("book", book);
			return "editBook.jsp";
		}
		else {
			Long userId = (Long) session.getAttribute("userId");
			User thisUser = userService.findUser(userId);
			book.setId(bookId);
			book.setUser(thisUser);
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/{bookId}/delete")
	public String deleteBook(@PathVariable("bookId") Long bookId) {
		Book thisBook = bookService.findBook(bookId);
		thisBook.setUser(null);
		bookService.deleteBook(bookId);
		return "redirect:/books";
	}
}
