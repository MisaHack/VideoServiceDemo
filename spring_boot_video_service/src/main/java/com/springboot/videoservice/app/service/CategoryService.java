package com.springboot.videoservice.app.service;

import java.util.List;

import com.springboot.videoservice.app.model.CategoryModel;

public interface CategoryService {
   CategoryModel saveCategory(CategoryModel category);
   List<CategoryModel> getAllCategories();
   CategoryModel getCategoryById(long id);
   CategoryModel updateCategory(CategoryModel category, long id);
   void deleteCategory(long id);
}
