package com.javaspring.productcategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.productcategory.models.Category;
import com.javaspring.productcategory.models.Product;
import com.javaspring.productcategory.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
	public List<Product> findProductsByCategory(Category category){
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> findProductsByNotThisCategory(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
}
