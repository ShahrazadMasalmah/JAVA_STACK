package com.javaspring.loginandregistration.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="User name is required!")
	@Size(min=3, max=50, message="User name must be between 3 and 50 characters!")
	@Pattern(regexp="^[A-Za-z\s]*$",message = "User name must be only letters!")
	private String userName;
	@NotBlank(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String email;
	@NotBlank(message="Password is required!")
	@Size(min=8, max=128, message="Password must be between 8 and 128 characters!")
	private String password;
	@Transient
	@NotBlank(message="Confirm Password is required!")
	@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters!")
	private String confirmPassword;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	  }
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	  }
	 
	public User() {}
	public User(
			@NotBlank(message = "User name is required!") @Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters!") @Pattern(regexp = "^[A-Za-z]*$", message = "User name must be only letters!") String userName,
			@NotBlank(message = "Email is required!") @Email(message = "Please enter a valid email!") String email,
			@NotBlank(message = "Password is required!") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters!") String password,
			@NotBlank(message = "Confirm Password is required!") @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters!") String confirmPassword) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
	 
}
