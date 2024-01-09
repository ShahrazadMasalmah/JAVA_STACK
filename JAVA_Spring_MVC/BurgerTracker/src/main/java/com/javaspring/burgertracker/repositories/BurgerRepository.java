package com.javaspring.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.burgertracker.models.Burger;


@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
	List<Burger> findAll();
	
	//List<Burger> findByNotesContaining(String search);
	
	//Long countByBurgerNameContaining(String search);
	
	//Long deleteByBurgerNameStartingWith(String search);
}


