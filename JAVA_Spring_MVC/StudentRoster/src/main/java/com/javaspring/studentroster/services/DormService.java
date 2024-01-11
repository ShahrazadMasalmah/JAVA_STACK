package com.javaspring.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.studentroster.models.Dorm;
import com.javaspring.studentroster.models.Student;
import com.javaspring.studentroster.repositories.DormRepository;

@Service
public class DormService {
	
	@Autowired
	DormRepository dormRepository;
	
	//return all the dorms
	public List<Dorm> allDorms(){
		return dormRepository.findAll();
	}
	
	//create a dorm
	public Dorm createDorm(Dorm dorm) {
		return dormRepository.save(dorm);
	}
	
	public Dorm findDorm(Long id) {
		Optional<Dorm> optionalDorm = dormRepository.findById(id);
		if(optionalDorm.isPresent()) {
			return optionalDorm.get();
		}
		else {
			return null;
		}
	}
	
	//update a dorm
	public Dorm updateDorm(Dorm dorm) {
		return dormRepository.save(dorm);
	}
	
	//delete a dorm
	public void deleteDorm(Long id) {
		dormRepository.deleteById(id);
	}
	
}
