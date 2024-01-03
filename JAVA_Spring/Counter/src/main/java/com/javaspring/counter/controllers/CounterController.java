package com.javaspring.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String home(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			int counter = (int)session.getAttribute("count");
			counter++;
			session.setAttribute("count", counter);
		}
		return "home.jsp";
	}
	
	@RequestMapping("/counter")
	public String counterPage() {
		return "counter.jsp";
	}
	
	@RequestMapping("/counter/2")
	public String counterPageByTwo(HttpSession session, Model model) {
		int countByTwo = (int) session.getAttribute("count");
		countByTwo+=2;
		model.addAttribute("visitCount", countByTwo);
		return "counter2.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/";
	}
}
