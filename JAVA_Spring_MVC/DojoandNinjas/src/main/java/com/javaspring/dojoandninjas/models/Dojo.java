package com.javaspring.dojoandninjas.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//...
@Entity
@Table(name="dojos")
public class Dojo {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @NotNull
 @Size(min = 5, max = 200, message="Dojo name must be at least 5 characters!")
 private String name;
 @Column(updatable=false)
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date createdAt;
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date updatedAt;
 @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
 private List<Ninja> ninjas;
 
 	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
 	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
 	
 	 public Dojo() {
 	     
 	 }
	
	public Dojo(@NotNull @Size(min = 5, max = 200, message = "Dojo name must be at least 5 characters!") String name,
		List<Ninja> ninjas) {
	super();
	this.name = name;
	this.ninjas = ninjas;
}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public List<Ninja> getNinjas() {
		return ninjas;
	}
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}

 
}

