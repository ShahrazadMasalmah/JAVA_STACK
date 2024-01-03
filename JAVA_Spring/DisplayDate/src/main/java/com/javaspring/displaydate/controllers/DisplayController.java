package com.javaspring.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DisplayController {
	@RequestMapping("/")
	public String main() {
		return "main.jsp";
	}
	
	@RequestMapping("/date")
	public String displayDate(Model model) {
		Date current_date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEE, MMM dd, YYYY");
		String date = dateFormat.format(current_date);
		model.addAttribute("date", date);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String displayTime(Model model) {
		Date current_time = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
		String time = timeFormat.format(current_time);
		model.addAttribute("time", time);
		return "time.jsp";
	}
}
