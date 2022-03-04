package com.springboot.videoservicenew.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservicenew.app.dto.CategoryDTO;
import com.springboot.videoservicenew.app.model.CategoryModel;
import com.springboot.videoservicenew.app.service.service2.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController { // Controller depends on Service layer

	@Autowired
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	// build CREATE Category REST API
	@PostMapping
	public ResponseEntity<CategoryModel> saveCategory(@RequestBody CategoryModel category){
	   return new ResponseEntity<CategoryModel>(categoryService.saveCategory(category), HttpStatus.CREATED);	
	}
	
	// build GET ALL Categories REST API, to return ALL Categories from DB	
    // http://localhost:8080/api/categories
    // this is dynamic path variable    
	@GetMapping
	public List<CategoryModel> getAllCategories(){
	   return categoryService.getAllCategories();
	}
	
	// build GET Category BY ID REST API, to return Category BY ID from DB
	@GetMapping("{id}")
	public ResponseEntity<CategoryModel> getCategoryById(@PathVariable("id") long category_id){
	   return new ResponseEntity<CategoryModel>(categoryService.getCategoryById(category_id), HttpStatus.OK);	
	}
	
	// build UPDATE Category Data REST API, to Update Category Data fields from DB
	@PutMapping("{id}")
	public ResponseEntity<CategoryModel> updateCategory(@PathVariable("id") long id, @RequestBody CategoryModel category){
	   return new ResponseEntity<CategoryModel>(categoryService.updateCategory(category, id), HttpStatus.OK);	
	}
	
	// build DELETE Employee Data REST API	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") long id){
	   
	   //delete employee from DB
	   categoryService.deleteCategory(id);
	   
	   return new ResponseEntity<String>("Category deleted successfully !", HttpStatus.OK);
	}
	
	// build GET ALL Categories as DTO format REST API, to return ALL Categories from DB in DTO format	
    // http://localhost:8080/api/categories/getAllCatAsDto
    // this is dynamic path variable    
	@GetMapping("/getAllCatAsDto")
	public List<CategoryDTO> getAllCategoriesAsDTO(){
       
	   return categoryService.getAllCategoriesAsDTO();
		
	}
	
	
}
