package com.javaspring.savetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.javaspring.savetravels.models.Expense;
import com.javaspring.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String home(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("expenses", expenseService.allExpenses());
		return "home.jsp";
	}
	
	 @PostMapping("/expense")
	    public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	        if (result.hasErrors()) {
	            return "home.jsp";
	        } else {
	        	expenseService.createExpense(expense);
	            return "redirect:/expenses";
	        }
	    }
	 
	 @GetMapping("/expenses/edit/{id}")
	 public String edit(@PathVariable("id") Long id, Model model) {
		 model.addAttribute("expense", expenseService.findExpense(id));
		 return "edit.jsp";
	 }
	 
	 @PutMapping("/expense/{id}")
	 public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		 if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	        	expenseService.updateExpense(expense);
	            return "redirect:/expenses";
	        }
	 }
	 
	 @GetMapping("/expenses/{id}")
	 public String showExpense(@PathVariable("id") Long id, Model model) {
		 model.addAttribute("expense", expenseService.findExpense(id));
		 return "show.jsp";
	 }
	 
	 @GetMapping("/expenses/delete/{id}")
	 public String delete(@PathVariable("id") Long id) {
		 expenseService.deleteExpense(id);
		 return "redirect:/expenses";
	 }
}
