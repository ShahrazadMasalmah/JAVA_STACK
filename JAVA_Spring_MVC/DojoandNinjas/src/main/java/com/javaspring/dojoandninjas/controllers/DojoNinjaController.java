package com.javaspring.dojoandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaspring.dojoandninjas.models.Dojo;
import com.javaspring.dojoandninjas.models.Ninja;
import com.javaspring.dojoandninjas.services.DojoService;
import com.javaspring.dojoandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class DojoNinjaController {
	
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojo/new";
	}
	
	@GetMapping("/dojo/new")
	public String showDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	
	@PostMapping("/dojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		 if (result.hasErrors()) {
	            return "dojo.jsp";
	        } else {
	        	dojoService.createDojo(dojo);
	            return "redirect:/ninja/new";
	        }
	}
	
	@GetMapping("/ninja/new")
	public String showNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "ninja.jsp";
	}
	
	@PostMapping("/ninja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		 if (result.hasErrors()) {
	            return "ninja.jsp";
	        } else {
	        	ninjaService.createNinja(ninja);
	            return "redirect:/dojo/" + ninja.getDojo().getId();
	        }
	}
	
	@GetMapping("/dojo/{dojoId}")
	public String showDojoNinjas(@PathVariable("dojoId") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "dojoNinjas.jsp";
	}
}
