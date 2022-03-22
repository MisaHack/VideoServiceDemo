package com.springboot.videoservicenew.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springboot.videoservicenew.app.dto.CategoryDTO;
import com.springboot.videoservicenew.app.model.CategoryModel;
import com.springboot.videoservicenew.app.service.service2.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController { // Controller depends on Service layer

	@Autowired
	private CategoryService categoryService;

	//we use constructor injection here, same as in Service
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/datetime")
	public String welcomePage(){
	   return "Welcome to Video Service app ! Current date and time on server is : " + LocalDateTime.now();
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

	@GetMapping("/list")
	public String listCategories(Model theModel){

		//get categories from db
		List<CategoryModel> theCategories = categoryService.getAllCategories();

		//add to the spring model
		theModel.addAttribute("categories", theCategories);

		return "categories/list-categories";
	}

    @GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){

		// create model attribute to bind form data
		CategoryModel category = new CategoryModel();

		theModel.addAttribute("category", category);

		return "categories/category-form";
	}

	@PostMapping("/save")
	public String saveCategoryThymeleaf(@ModelAttribute("category") CategoryModel category){

		// save the category
        categoryService.saveCategory(category);

		// use a redirect to prevent duplicate submisions
		return "redirect:/categories/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("categoryId") int id, Model theModel){

		//get the Category from the service
        CategoryModel category = categoryService.getCategoryById(id);

		//set category as a model attribute to pre-populate the form
        theModel.addAttribute("category", category);

		//send over to our form
		return "categories/category-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("categoryId") int id){

		// delete the category
		categoryService.deleteCategory(id);

		// redirect to /categories/list
		return "redirect:/categories/list";

	}



}
