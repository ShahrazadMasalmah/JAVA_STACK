package com.javaspring.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.studentroster.models.Student;
import com.javaspring.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	//return all the students
	public List<Student> allStudents(){
		return studentRepository.findAll();
	}
	
	//create a student
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student findStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		}
		else {
			return null;
		}
	}
	
	//update a student
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	//delete a student
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
	public void removeFromDorm(Student student) {
		student.setDorm(null);
		studentRepository.save(student);
	}
	
}
