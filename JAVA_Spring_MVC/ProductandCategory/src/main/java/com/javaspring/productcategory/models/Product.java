package com.javaspring.productcategory.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//...
@Entity
@Table(name="products")
public class Product {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @NotNull
 @Size(min=2, message="Product name must be at least 2 characters!")
 private String name;
 @NotNull
 @Size(min = 5, message="Product description must be at least 5 characters!")
 @Column(columnDefinition="TEXT")
 private String description;
 @NotNull
 private float price;
 @Column(updatable=false)
 @DateTimeFormat(pattern = "yyyy-MM-dd")
 private Date createdAt;
 @DateTimeFormat(pattern = "yyyy-MM-dd")
 private Date updatedAt;
 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable(
     name = "categories_products", 
     joinColumns = @JoinColumn(name = "product_id"), 
     inverseJoinColumns = @JoinColumn(name = "category_id")
 )
 private List<Category> categories;
 
 @PrePersist
 public void onCreate() {
	 this.createdAt = new Date();
 }
 
 @PreUpdate
 public void onUpdate() {
	 this.updatedAt = new Date();
 }
 
 //Empty constructor
 public Product() {
     
 }

 //Constructor with fields
public Product(@NotNull @Size(min = 2, message = "Product name must be at least 2 characters!") String name,
		@NotNull @Size(min = 5, message = "Product description must be at least 5 characters!") String description,
		@NotEmpty(message = "Product price is required!") float price, List<Category> categories) {
	super();
	this.name = name;
	this.description = description;
	this.price = price;
	this.categories = categories;
}

//Getters and Setters
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

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
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

public List<Category> getCategories() {
	return categories;
}

public void setCategories(List<Category> categories) {
	this.categories = categories;
}
 
 
}

