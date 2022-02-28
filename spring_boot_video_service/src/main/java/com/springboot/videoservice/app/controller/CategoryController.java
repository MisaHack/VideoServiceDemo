package com.springboot.videoservice.app.controller;

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

import com.springboot.videoservice.app.model.CategoryModel;
import com.springboot.videoservice.app.service.CategoryService;

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
	
	// build GET ALL Category REST API, to return ALL Categoryss from DB	
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
}
