package com.javaspring.productcategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.productcategory.models.Category;
import com.javaspring.productcategory.models.Product;
import com.javaspring.productcategory.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}
	
	public List<Category> findCategoriesByProduct(Product product){
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> findCategoriesByNotThisProduct(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
}
