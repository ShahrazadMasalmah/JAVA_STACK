package com.javaspring.productcategory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaspring.productcategory.models.Category;
import com.javaspring.productcategory.models.Product;
import com.javaspring.productcategory.services.CategoryService;
import com.javaspring.productcategory.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProducts());
		return "home.jsp";
	}
	
	 // adding a new product
	  @GetMapping("/products/new")
	  private String addProduct(@ModelAttribute("product") Product product) {
	    return "addProduct.jsp";
	  }
	  
	// adding a new category
	  @GetMapping("/categories/new")
	  private String addCategory(@ModelAttribute("category") Category category) {
	    return "addCategory.jsp";
	  }
	  
	  @PostMapping("/products/new")
	  private String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
	    if (result.hasErrors()) {
	      return "addProduct.jsp";
	    } else {
	      productService.createProduct(product);
	      return "redirect:/";
	    }
	  }
	  
	  @PostMapping("/categories/new")
	  private String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
	    if (result.hasErrors()) {
	      return "addCategory.jsp";
	    } else {
	      categoryService.createCategory(category);
	      return "redirect:/";
	    }
	  }
	  
	  @GetMapping("/products/{productId}")
	  public String showProduct(@PathVariable("productId") Long productId, Model model) {
		  Product product = productService.findProduct(productId);
		  List<Category> productNotCategories = categoryService.findCategoriesByNotThisProduct(product);
		  model.addAttribute("product", product);
		  model.addAttribute("categories", productNotCategories);
		  return "viewProduct.jsp";
	  }
	  
	  @GetMapping("/categories/{categoryId}")
	  public String showCategory(@PathVariable("categoryId") Long categoryId, Model model) {
		  Category category = categoryService.findCategory(categoryId);
		  List<Product> categoryNotProducts = productService.findProductsByNotThisCategory(category);
		  model.addAttribute("category", category);
		  model.addAttribute("products", categoryNotProducts);
		  return "viewCategory.jsp";
	  }
	  
	  @PostMapping("/products/{productId}")
	  public String addCategoryToProduct(@PathVariable("productId") Long productId, 
			  @RequestParam(value="categoryId") Long categoryId) {
		  Product thisProduct = productService.findProduct(productId);
		  Category thisCategory = categoryService.findCategory(categoryId);
		  thisProduct.getCategories().add(thisCategory);
		  productService.updateProduct(thisProduct);
		  return "redirect:/"; 
	  }
	  
	  @PostMapping("/categories/{categoryId}")
	  public String addProductToCategory(@PathVariable("categoryId") Long categoryId, 
			  @RequestParam(value="productId") Long productId) {
		  Product thisProduct = productService.findProduct(productId);
		  Category thisCategory = categoryService.findCategory(categoryId);
		  thisCategory.getProducts().add(thisProduct);
		  categoryService.updateCategory(thisCategory);
		  return "redirect:/"; 
	  }
}
