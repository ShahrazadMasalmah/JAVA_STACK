package com.javaspring.burgertracker.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaspring.burgertracker.models.Burger;
import com.javaspring.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	private final BurgerService burgerService;
	
	public BurgerController(BurgerService burgerService) {
		this.burgerService =  burgerService;
	}
	
	@RequestMapping("/")
    public String index(@ModelAttribute("burger") Burger burger, Model model) {
        List<Burger> burgers = burgerService.allBurgers();
        model.addAttribute("burgers", burgers);
        return "home.jsp";
    }
	
	 @PostMapping("/burger")
	    public String createburger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
	        if (result.hasErrors()) {
	            return "home.jsp";
	        } else {
	        	burgerService.createBurger(burger);
	            return "redirect:/";
	        }
	    }
	 
	 @RequestMapping("/burgers/edit/{id}")
	 public String edit(@PathVariable("id") Long id, Model model) {
			Burger burger = burgerService.findBurger(id);
			model.addAttribute("burger", burger);
			return "edit.jsp";
		}
	 
	 @PutMapping(value="/burger/{id}")
		public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
			if(result.hasErrors()) {
				return "edit.jsp";
			}
			else {
				burgerService.updateBurger(burger);
				return "redirect:/";
			}
		}
}
