package com.javaspring.productcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.productcategory.models.Category;
import com.javaspring.productcategory.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	

	List<Product> findAll();
	
    // Retrieves a list of all products for a particular category
    List<Product> findAllByCategories(Category category);
    
    // Retrieves a list of any products a particular category
    // does not belong to.
    List<Product> findByCategoriesNotContains(Category category);
}
