package com.javaspring.projectmanager.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//Define that an entity will be saved to the database, and define the table name, here it is called users

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// First name
	@NotEmpty(message = "First name is required!")
	@Size(min = 3, message = "First name must be at least 3 characters!")
	@Pattern(regexp="^[A-Za-z]*$",message = "First name must be only letters!")
	private String firstName;
	
	// Last name
	@NotEmpty(message = "Last name is required!")
	@Size(min = 3, message = "Last name must be at least 3 characters!")
	@Pattern(regexp="^[A-Za-z]*$",message = "Last name must be only letters!")
	private String lastName;
	
	@NotEmpty(message = "Email is required!")
	@Email(message = "Please enter a valid email!")
	private String email;
	
	@NotEmpty(message = "Password is required!")
	@Size(min = 8, message = "Password must be at least 8 characters!")
	private String password;
	
	@Transient
	@NotEmpty(message = "Confirm Password is required!")
	@Size(min = 8, message = "Confirm Password must be at least 8 characters!")
	private String confirmPassword;
	
	// adding the created at and updated at is crusial for me
	
	// created at and the updated at columns
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="leader", fetch = FetchType.LAZY)
	private List<Project> projects;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Task> userTasks;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	   name = "members_projects", 
	   joinColumns = @JoinColumn(name = "member_id"), 
	   inverseJoinColumns = @JoinColumn(name = "project_id")
	)
	private List<Project> partOfProjects;
	
	
	@PrePersist
	protected void onCreate() {
	 this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
	 this.updatedAt = new Date();
	}
	
	public User() {}

	public User(
			@NotEmpty(message = "First name is required!") @Size(min = 3, message = "First name must be at least 3 characters!") @Pattern(regexp = "^[A-Za-z]*$", message = "First name must be only letters!") String firstName,
			@NotEmpty(message = "Last name is required!") @Size(min = 3, message = "Last name must be at least 3 characters!") @Pattern(regexp = "^[A-Za-z]*$", message = "Last name must be only letters!") String lastName,
			@NotEmpty(message = "Email is required!") @Email(message = "Please enter a valid email!") String email,
			@NotEmpty(message = "Password is required!") @Size(min = 8, message = "Password must be at least 8 characters!") String password,
			List<Project> projects, List<Task> userTasks, List<Project> partOfProjects) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.projects = projects;
		this.userTasks = userTasks;
		this.partOfProjects = partOfProjects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Task> getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(List<Task> userTasks) {
		this.userTasks = userTasks;
	}

	public List<Project> getPartOfProjects() {
		return partOfProjects;
	}

	public void setPartOfProjects(List<Project> partOfProjects) {
		this.partOfProjects = partOfProjects;
	}
	
	
	
	

}
