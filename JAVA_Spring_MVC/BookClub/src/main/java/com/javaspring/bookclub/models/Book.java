package com.javaspring.bookclub.models;

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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Title is required!")
	@Size(min=3, message="Title must be at least 3 characters!")
	private String title;
	
	@NotEmpty(message="Author is required!")
	@Size(min=3, message="Author must be at least 3 characters!")
	private String author;
	
	@NotEmpty(message="Thoughts Should not be empty!")
	@Size(min=5, message="Thoughts must be at least 5 characters!")
	private String thoughts;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	  }
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	  }
	 
	public Book() {}
	public Book(
			@NotEmpty(message = "Title is required!") @Size(min = 3, message = "Title must be at least 3 characters!") String title,
			@NotEmpty(message = "Author is required!") @Size(min = 3, message = "Author must be at least 3 characters!") String author,
			@NotEmpty(message = "Thoughts Should not be empty!") @Size(min = 5, message = "Thoughts must be at least 5 characters!") String thoughts,
			User user) {
		super();
		this.title = title;
		this.author = author;
		this.thoughts = thoughts;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getThoughts() {
		return thoughts;
	}
	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
