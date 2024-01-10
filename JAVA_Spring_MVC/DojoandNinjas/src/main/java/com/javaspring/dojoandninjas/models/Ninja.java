package com.javaspring.dojoandninjas.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//..
@Entity
@Table(name="ninjas")
public class Ninja {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @NotNull
 @Size(min = 5, max = 200, message="Ninja first name must be at least 5 characters!")
 private String firstName;
 @NotNull
 @Size(min = 5, max = 200, message="Ninja last name must be at least 5 characters!")
 private String lastName;
 @NotNull
 @Min(value=15, message="Ninja age must be at least 15!")
 @Max(value=60, message="Ninja age must be less than 60!")
 private int age;
 @Column(updatable=false)
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date createdAt;
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date updatedAt;
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="dojo_id")
 private Dojo dojo;
 
 @PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	
 public Ninja() {
     
 }
public Ninja(
		@NotNull @Size(min = 5, max = 200, message = "Ninja first name must be at least 5 characters!") String firstName,
		@NotNull @Size(min = 5, max = 200, message = "Ninja last name must be at least 5 characters!") String lastName,
		@NotNull @Min(value = 15, message = "Ninja age must be at least 15!") @Max(value = 60, message = "Ninja age must be less than 60!") int age,
		Dojo dojo) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.dojo = dojo;
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
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
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
public Dojo getDojo() {
	return dojo;
}
public void setDojo(Dojo dojo) {
	this.dojo = dojo;
}
 
}


