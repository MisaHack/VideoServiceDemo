package com.springboot.videoservicenew.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.videoservicenew.app.dto.CategoryDTO;
import com.springboot.videoservicenew.app.exception.ResourceNotFoundException;
import com.springboot.videoservicenew.app.model.CategoryModel;
import com.springboot.videoservicenew.app.repository.CategoryRepository;
import com.springboot.videoservicenew.app.service.service2.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	//Mapping DTO to Entity, and vice versa
	private ModelMapper mapper;
	
	private CategoryRepository categoryRepository;

	//we are using constructor injection
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
	
//	Service for convering Category Entity to Category with less data
//  ----->>> THIS IS BAD WAY TO CONVERT, BETTER USE - MODEL MAPPER - INSTEAD !
//	public CategoryDTO convertEntityToDTO(CategoryModel categoryModel){
//	   
//	   CategoryDTO categoryDTO = new CategoryDTO();
//	   
//	   categoryDTO.setCategory_name(categoryModel.getCategory_name());
//	   
//	   return categoryDTO;  
//	   
//	}
	
	//converting Entity to DTO
	public CategoryDTO convertEntityToDTO(CategoryModel categoryModel){
	   
	   CategoryDTO categoryDTO = mapper.map(categoryModel, CategoryDTO.class);	
	   
	   return categoryDTO;  
	   
	}
	
	//converting DTO to Entity
	public CategoryModel convertDTOToEntity(CategoryDTO categoryDTO){
	   
	   CategoryModel categoryModel = mapper.map(categoryDTO, CategoryModel.class);
	   
	   return categoryModel;
	}
	
	//Return All Categories converted in DTO format
	public List<CategoryDTO> getAllCategoriesAsDTO() {
		   
		List<CategoryModel> categories =  categoryRepository.findAll();
		   
	    List<CategoryDTO> categoriesDTO = new ArrayList<>();
		   
		CategoryServiceImpl catSerImpl = new CategoryServiceImpl(categoryRepository);
		   
		for(int i=0; i < categories.size(); i++){
		   categoriesDTO.add(catSerImpl.convertEntityToDTO(categories.get(i)));
			  
		}
		   
		return categoriesDTO;
	}

}
