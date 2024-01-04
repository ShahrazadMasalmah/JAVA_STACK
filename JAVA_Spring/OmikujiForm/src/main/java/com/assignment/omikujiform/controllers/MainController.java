package com.assignment.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/process")
	public String process(HttpSession session,
		@RequestParam(value="number") int number,
		@RequestParam(value="city") String city,
		@RequestParam(value="name") String name,
		@RequestParam(value="thing") String thing,
		@RequestParam(value="hobby") String hobby,
		@RequestParam(value="message") String message) {
		
				
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("thing", thing);
		session.setAttribute("hobby", hobby);
		session.setAttribute("message", message);
		return "redirect:/omikuji/show";
	}
	@RequestMapping("/omikuji/show")
	public String show() {
		return "show.jsp";
	}

}
