package com.javaspring.burgertracker.services;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaspring.burgertracker.models.Burger;
import com.javaspring.burgertracker.repositories.BurgerRepository;


@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	//returns all the burgers
	public List<Burger> allBurgers(){
		return burgerRepository.findAll();
	}
	
	//creates a burger
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		}
		else {
			return null;
		}
	}
	
	//updates a burger
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	//delete a burger
	public void deleteBurger(Long id) {
		burgerRepository.deleteById(id);
	}
}

