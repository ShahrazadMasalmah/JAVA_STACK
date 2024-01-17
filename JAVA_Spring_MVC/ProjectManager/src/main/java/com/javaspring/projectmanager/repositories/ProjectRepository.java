package com.javaspring.projectmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaspring.projectmanager.models.Project;
import com.javaspring.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	List<Project> findAll();
	
	public List<Project> findByMembersContaining(User user);
	
	public List<Project> findByMembersNotContaining(User user);
	
	//public List<Project> findByLeaderNotContaining(User user);
	
	 @Query(value = "SELECT p.id, p.title, users.first_name, p.due_date FROM projects p " +
		      "inner join users on p.leader_id = users.id " +
		      "WHERE p.leader_id <> :id " +
		      "AND :id NOT IN ( " +
		      "SELECT member_id FROM members_projects mp " +
		      "WHERE mp.project_id = p.id)", nativeQuery = true)
	 List<Object[]> findProjectsNotJoinedByUser(@Param("id") Long id);
	
	 @Query(value = "SELECT projects.id, projects.title, projects.description, projects.due_date, users.first_name " +
		      "FROM projects " +
		      "INNER JOIN members_projects ON projects.id = members_projects.project_id " +
		      "INNER JOIN users ON members_projects.member_id = users.id " +
		      "WHERE members_projects.member_id = :id", nativeQuery = true)
	 List<Object[]> findAllProjectsForUser(@Param("id") Long id);
	
		  // works // is Leader + part of
	 @Query(value = "SELECT projects.id, projects.title, leader.first_name, projects.due_date ,projects.leader_id FROM projects INNER JOIN users AS leader ON projects.leader_id = leader.id LEFT JOIN members_projects ON projects.id = members_projects.project_id INNER JOIN users ON (projects.leader_id = users.id OR members_projects.member_id = users.id) WHERE users.id = :id", nativeQuery = true)
	 List<Object[]> allProjectsUserIsLeader(@Param("id") Long id);
		  
	 @Query(value = "SELECT projects.id, projects.title ,users.first_name, Date(projects.due_date) as due_date FROM projects "
		      +
		      "join users on leader_id = users.id  " +
		      "WHERE projects.id NOT IN ( " +
		      "SELECT projects.id " +
		      "FROM projects " +
		      "WHERE joinee_id = :id) ", nativeQuery = true)
	 List<Object[]> findAllProjectsNotinUser(@Param("id") Long id);	  
}
