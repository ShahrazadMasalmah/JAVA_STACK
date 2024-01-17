package com.javaspring.projectmanager.controllers;

import java.util.List;

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

import com.javaspring.projectmanager.models.LoginUser;
import com.javaspring.projectmanager.models.Project;
import com.javaspring.projectmanager.models.Task;
import com.javaspring.projectmanager.models.User;
import com.javaspring.projectmanager.services.ProjectService;
import com.javaspring.projectmanager.services.TaskService;
import com.javaspring.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired 
	TaskService taskService;
	
	@GetMapping("/")
	public String registerAndLogin(@ModelAttribute("newUser") User user, Model model) {
	    // Bind empty User and LoginUser objects to the JSP
	    // to capture the form input
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new LoginUser());
	    return "login.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, 
			Model model, HttpSession session) {
		User registeredUser = userService.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		else {
			session.setAttribute("userId", registeredUser.getId());
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result,
			Model model, HttpSession session) {
		User loginUser = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		else {
			session.setAttribute("userId", loginUser.getId());
			return "redirect:/dashboard";
		}
	}
	
	 @GetMapping("/dashboard")
	  public String homePage(Model model, HttpSession session) {
	    Long newUserId = (Long) session.getAttribute("userId");
	    if(newUserId == null) {
	    	return "redirect:/";
	    }
	    else {
		    User thisUser = userService.findUser(newUserId);
		    model.addAttribute("thisUser", thisUser);
	
		    // Query to return all the projects the user is part of
	
		    List<Object[]> allProjectsUserIsLeader = projectService.allProjectsCreatedByUser(newUserId);
		    model.addAttribute("leaderProjects", allProjectsUserIsLeader);
		    // System.out.println(allProjects);
		    // model.addAttribute("allProjects", allProjects);
		    // Query to return all the projects the user is not part of
	
		    List<Object[]> notProjects = projectService.findProjectsNotRelatedToUser(newUserId);
		    model.addAttribute("notProjects", notProjects);
	
		    return "dashboard.jsp";
	    }
	  }
	 
	 @GetMapping("/logout")
	  public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/";
	  }
	 
	 @GetMapping("/projects/new")
	  public String addProjectsPage(@ModelAttribute("project") Project project, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		
	    model.addAttribute("project", project);
	    return "addProject.jsp";
	  }
	 
	 @PostMapping("/projects/new")
	  public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result,
	      HttpSession session, Model model) {
	    if (result.hasErrors()) {
	      return "addProject.jsp";
	    } else {
	      Long userId = (Long) session.getAttribute("userId");
	      User user = userService.findUser(userId);

	      project.setLeader(user);
	      projectService.createProject(project);
	      return "redirect:/dashboard";
	    }
	  }
	 
	 @GetMapping("/projects/{projectId}/join")
	  public String JoinTeamProject(@PathVariable("projectId") Long id, HttpSession session) {
	    Project project = projectService.findProject(id);
	    Long userId = (Long) session.getAttribute("userId");
	    User user = userService.findUser(userId);

	    project.getMembers().add(user);

	    projectService.updateProject(project);
	    //System.out.println("Successs!");
	    return "redirect:/dashboard";
	  }
	 
	 @GetMapping("/projects/{projectId}/leave")
	  public String leaveTeamProject(@PathVariable("projectId") Long id, HttpSession session) {
	    Project project = projectService.findProject(id);
	    Long userId = (Long) session.getAttribute("userId");
	    User user = userService.findUser(userId);
	    
	    project.getMembers().remove(user);
	    projectService.updateProject(project);
	    return "redirect:/dashboard";
	  }
	 
	 @GetMapping("/projects/{projectId}/edit")
	  public String editProject(@PathVariable("projectId") Long id, Model model) {
	    Project project = projectService.findProject(id);
	    model.addAttribute("project", project);
	    return "editProject.jsp";
	  }
	 
	 @PutMapping("/projects/{projectId}/edit")
	  public String updateProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model,
	      HttpSession session, @PathVariable("projectId") Long id) {
		 Project thisProject = projectService.findProject(id);
	    if (result.hasErrors()) {
	      model.addAttribute("project", thisProject);
	      return "editProject.jsp";
	    } 
	    else {
	      Long userId = (Long) session.getAttribute("userId");
	      User user = userService.findUser(userId);
	      project.setId(id);
	      project.setLeader(user);
	      projectService.updateProject(project);
	      return "redirect:/dashboard";
	    }
	  }
	 
	 @GetMapping("/projects/{projectId}")
	  public String showProject(@PathVariable("projectId") Long id, Model model) {
	    Project project = projectService.findProject(id);
	    model.addAttribute("project", project);
	    return "viewProject.jsp";
	  }
	 
	 @DeleteMapping("/projects/{projectId}/delete")
	  public String deleteProject(@PathVariable("projectId") Long id, Model model, HttpSession session) {
		 Long userId = (Long) session.getAttribute("userId");
		 User user = userService.findUser(userId);
		 Project project = projectService.findProject(id);
		 project.setLeader(user);
	     projectService.deleteProject(id);
	     return "redirect:/dashboard";
	  }
	 
	 @GetMapping("/projects/{projectId}/tasks")
	 public String viewProjectTasks(@ModelAttribute("task") Task task, Model model,
			 @PathVariable("projectId") Long id) {
		
		 Project project = projectService.findProject(id);
		 model.addAttribute("project", project);
		 return "addTasks.jsp";
	 }
	 
	 @PostMapping("/projects/{projectId}/tasks")
	 public String createTasks(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model,
	      HttpSession session, @PathVariable("projectId") Long id) {
		 
		 Long userId = (Long) session.getAttribute("userId");
		 User user = userService.findUser(userId);
		 
		 Project project = projectService.findProject(id);
		 
		 if(result.hasErrors()) {
			 model.addAttribute("project", project);
			 return "addTasks.jsp";
		 }
		 else {
			task.setProject(project);
			task.setUser(user);
			taskService.createTask(task);
			return "redirect:/dashboard";
		 }
	 }

}
