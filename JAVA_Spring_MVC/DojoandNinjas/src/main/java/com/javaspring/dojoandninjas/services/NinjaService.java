package com.javaspring.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.dojoandninjas.models.Ninja;
import com.javaspring.dojoandninjas.repositories.NinjaRepository;


@Service
public class NinjaService {
	
	@Autowired
	NinjaRepository ninjaRepository;
	
	
	//returns all the ninjas
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	//creates a ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
	
	//updates a ninja
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	//delete a ninja
	public void deleteExpense(Long id) {
		ninjaRepository.deleteById(id);
	}
}

