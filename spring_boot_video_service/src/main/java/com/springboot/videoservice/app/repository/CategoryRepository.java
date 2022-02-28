package com.springboot.videoservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.videoservice.app.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{

}
