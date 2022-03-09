package com.springboot.videoservicenew.app.service.service2;

import java.util.List;

import com.springboot.videoservicenew.app.dto.CategoryDTO;
import com.springboot.videoservicenew.app.model.CategoryModel;

public interface CategoryService {
   CategoryModel saveCategory(CategoryModel category);
   List<CategoryModel> getAllCategories();
   CategoryModel getCategoryById(long id);
   CategoryModel updateCategory(CategoryModel category, long id);
   void deleteCategory(long id);
   List<CategoryDTO> getAllCategoriesAsDTO();
   CategoryDTO convertEntityToDTO(CategoryModel categoryModel);
   CategoryModel convertDTOToEntity(CategoryDTO categoryDTO);
   
}
