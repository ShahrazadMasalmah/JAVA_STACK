package com.javaspring.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.projectmanager.models.Project;
import com.javaspring.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {

	 @Autowired
	 private ProjectRepository projectRepo;
	 
	 public List<Project> allProjects(){
			return projectRepo.findAll();
		}
		
		public Project createProject(Project project) {
			return projectRepo.save(project);
		}
		
		public Project updateProject(Project project) {
			return projectRepo.save(project);
		}
		
		public Project findProject(Long id) {
			Optional<Project> optionalProject = projectRepo.findById(id);
			
			if(optionalProject.isPresent()) {
				return optionalProject.get();
			}
			else {
				return null;
			}
		}
		
		public void deleteProject(Long id) {
			projectRepo.deleteById(id);
		}
		
	
	 public List<Object[]> findAllProjectsContainingUser(Long id){

		    return projectRepo.findAllProjectsForUser(id);
		  }

	  public List<Object []> allProjectsCreatedByUser(Long id){
	  return projectRepo.allProjectsUserIsLeader(id);
	  }

	  public List<Object[]> findProjectsNotRelatedToUser(Long id){
			return projectRepo.findProjectsNotJoinedByUser(id);
		}
}
