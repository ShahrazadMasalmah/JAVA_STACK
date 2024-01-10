package com.javaspring.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.dojoandninjas.models.Dojo;
import com.javaspring.dojoandninjas.repositories.DojoRepository;


@Service
public class DojoService {
	
	@Autowired
	DojoRepository dojoRepository;
	
	
	//returns all the dojos
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	//creates a dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
	//updates a dojo
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	//delete a dojo
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
}

