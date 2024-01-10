package com.javaspring.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.savetravels.models.Expense;
import com.javaspring.savetravels.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	
	//returns all the expenses
	public List<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	
	//creates an expense
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
	
	//updates an expense
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	//delete an expense
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}

