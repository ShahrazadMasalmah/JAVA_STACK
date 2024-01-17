package com.javaspring.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.projectmanager.models.Task;
import com.javaspring.projectmanager.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepo;
	
	public List<Task> allTasks(){
		return taskRepo.findAll();
	}
	
	public Task createTask(Task task) {
		return taskRepo.save(task);
	}
	
	public Task updateTask(Task task) {
		return taskRepo.save(task);
	}
	
	public Task findTask(Long id) {
		Optional<Task> optionalTask = taskRepo.findById(id);
		
		if(optionalTask.isPresent()) {
			return optionalTask.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteTask(Long id) {
		taskRepo.deleteById(id);
	}
}
