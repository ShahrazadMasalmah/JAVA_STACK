package com.javaspring.studentroster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaspring.studentroster.models.Dorm;
import com.javaspring.studentroster.models.Student;
import com.javaspring.studentroster.services.DormService;
import com.javaspring.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class DormStudentController {
	
	@Autowired
	DormService dormService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dorms";
	}
	
	@GetMapping("/dorms")
	public String showDorms(Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "ShowDorms.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String showCreateDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "CreateDorm.jsp";
	}
	
	@GetMapping("/students/new")
	public String showCreateStudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "CreateStudent.jsp";
	}
	
	@PostMapping("/create/dorm")
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if(result.hasErrors()) {
			return "CreateDorm.jsp";
		}
		else {
			dormService.createDorm(dorm);
			return "redirect:/dorms/new";
		}
	}
	
	@PostMapping("/create/student")
	public String createDorm(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dorms", dormService.allDorms());
			return "CreateStudent.jsp";
		}
		else {
			studentService.createStudent(student);
			return "redirect:/students/new";
		}
	}
	
	@GetMapping("/dorms/{dormId}")
	public String showStudents(@PathVariable("dormId") Long id, Model model) {
		model.addAttribute("dorm", dormService.findDorm(id));
		model.addAttribute("allStudents", studentService.allStudents());
		return "ShowDormStudents.jsp";
	}
	
	@GetMapping("/students/remove/{studentId}")
	public String removeStudent(@PathVariable("studentId") Long id) {
		studentService.removeFromDorm(studentService.findStudent(id));
		return "redirect:/dorms";
	}
	
	@GetMapping("/add/student/{dormId}")
	public String addStudent(@RequestParam(value="studentId") Long studentId, @PathVariable("dormId") Long dormId,
			Model model) {
		Dorm dorm = dormService.findDorm(dormId);
		Student student = studentService.findStudent(studentId);
		Dorm thisDorm = student.getDorm();
		if(thisDorm == null) {
			student.setDorm(dorm);
			studentService.updateStudent(student);
			return "redirect:/dorms/" + dormId;
		}
		else {
			return "redirect:/dorms/" + dormId;
		}
	}
}
