package com.springboot.videoservicenew.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springboot.videoservicenew.app.dto.CategoryDTO;
import com.springboot.videoservicenew.app.model.CategoryModel;
import com.springboot.videoservicenew.app.repository.CategoryRepository;
import com.springboot.videoservicenew.app.service.impl.CategoryServiceImpl;

@DataJpaTest
@Transactional // staviti obavezno na test klase
public class CategoryServiceTest {
	
   @Autowired
   CategoryRepository categoryRepository;
   
   // we want clean state of DB after every test
   @AfterEach
   void cleanAllDataFromDB(){
	  categoryRepository.deleteAll(); 
   }

   @Test
   public void itShouldReturnEntityNameConvertedToDTOName(){
	   
	  //given
	  CategoryModel category = new CategoryModel();
	  category.setCategory_name("Horror");
	  CategoryServiceImpl categoryService = new CategoryServiceImpl(categoryRepository);
	     
	  //when
	  CategoryDTO categoryDTO = categoryService.convertEntityToDTO(category);
	  
	  //then
	  String category_name = "Horror";
	  assertThat(category_name).isEqualTo(categoryDTO.getCategory_name());
	  
   }
   
   public void itShouldReturnEntityConvertedToDTO(){}
}
