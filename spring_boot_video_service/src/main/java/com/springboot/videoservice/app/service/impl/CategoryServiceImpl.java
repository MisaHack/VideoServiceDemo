package com.springboot.videoservice.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.exception.ResourceNotFoundException;
import com.springboot.videoservice.app.model.CategoryModel;
import com.springboot.videoservice.app.repository.CategoryRepository;
import com.springboot.videoservice.app.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public CategoryModel saveCategory(CategoryModel category) {
	   return categoryRepository.save(category);
	}

	@Override
	public List<CategoryModel> getAllCategories() {
	   return categoryRepository.findAll();
	}

	@Override
	public CategoryModel getCategoryById(long id) {
	   Optional<CategoryModel> category = categoryRepository.findById(id);
	   
	   if(category.isPresent()){
		  return category.get();  
	   }
	   else{
		  throw new ResourceNotFoundException("Category", "id", id);
	   }
	}

	@Override
	public CategoryModel updateCategory(CategoryModel category, long id) {
	   
	   //we need to check does Category with the given id exist in DB or not
	   CategoryModel existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
	   
	   existingCategory.setCategory_name(category.getCategory_name());
	   
	   //save existing Category to DB
	   categoryRepository.save(existingCategory);
	   return existingCategory;
	}

	@Override
	public void deleteCategory(long id) {
	   
	   //check whether a Category exist in DB or not
	   categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
	   
	   categoryRepository.deleteById(id);
		
	}

}
