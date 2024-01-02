package com.javaspring.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="first_name", required = false, defaultValue = "Human") String searchFirstName,
			@RequestParam(value="last_name", required = false, defaultValue = "") String searchLastName,
			@RequestParam(value="times", required = false, defaultValue = "1") String searchTime) {
		
		String message = String.format("Hello %s %s ",searchFirstName, searchLastName);
		return message.repeat(Integer.parseInt(searchTime));
	}
}
