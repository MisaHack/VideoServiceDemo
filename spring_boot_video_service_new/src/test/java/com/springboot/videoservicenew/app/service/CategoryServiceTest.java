package com.springboot.videoservicenew.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springboot.videoservicenew.app.dto.CategoryDTO;
import com.springboot.videoservicenew.app.model.CategoryModel;
import com.springboot.videoservicenew.app.repository.CategoryRepository;
import com.springboot.videoservicenew.app.service.impl.CategoryServiceImpl;

// we can add @ExtendWith(MockitoExtension.class)  annotation instead :
// private AutoCloseable autoCloseable;
// autoCloseable = MockitoAnnotations.openMocks(this);
// @AfterEach
// void tearDown() throws Exception{autoCloseable.close();}

@DataJpaTest
@Transactional // staviti obavezno na test klase, zbog toga da bi baza uvek bila cista
public class CategoryServiceTest {

	//we know that Category Repository implementation really works
	//so we can Mock its implementation
	//benefit is that our unit test is now fast
	//we don't need to bring up the  Data Base, create the table, insert new Category, drop the database...
	//and similar things
	@Mock
	private CategoryRepository categoryRepository;
	
	private AutoCloseable autoCloseable;
	
	private CategoryServiceImpl underTest;
	
	//this will execute before each test
	//we want fresh instance on Category Service each time
	@BeforeEach
	void setUp(){
	   autoCloseable = MockitoAnnotations.openMocks(this);
	   underTest = new CategoryServiceImpl(categoryRepository);	   
	}

	// we want clean state of DB after every test
	//@AfterEach
	//void cleanAllDataFromDB() {
	//	categoryRepository.deleteAll();
	//}
	
	@Test
	void canAddCategory(){
	   //given
	   CategoryModel category = new CategoryModel();
	   category.setCategory_name("Action");
	   
	   //when
	   underTest.saveCategory(category);
	   
	   //then
	   ArgumentCaptor<CategoryModel> categoryArgumentCaptor = ArgumentCaptor.forClass(CategoryModel.class);
	   
	   //--we verify that Repository was invoked with Save() method
	   //--and at the same time we capture the value
	   //--so that we can make sure that the value is exact same one
	   //--which was invoked by the UnderTest
	   verify(categoryRepository).save(categoryArgumentCaptor.capture());
	   
	   CategoryModel capturedCategory = categoryArgumentCaptor.getValue();
	   
	   assertThat(capturedCategory).isEqualTo(category);
	   
	}
	
	//this method will be called after each test
	@AfterEach
	void tearDown() throws Exception{
	   //this will allow us to close resource after the test
	   autoCloseable.close();	
	}
	
	@Test
	void canGetAllCategories(){
	   //when
	   underTest.getAllCategories();
	   
	   //then
	   verify(categoryRepository).findAll();
	}

	@Test
	@Disabled //this annotation disables Test that is market with it
	public void itShouldReturnEntityNameConvertedToDTOName() {

		// given
		CategoryModel category = new CategoryModel();
		category.setCategory_name("Horror");
		CategoryServiceImpl categoryService = new CategoryServiceImpl(categoryRepository);

		// when
		CategoryDTO categoryDTO = categoryService.convertEntityToDTO(category);

		// then
		String category_name = "Horror";
		assertThat(category_name).isEqualTo(categoryDTO.getCategory_name());

	}

	@Test
	public void itShouldReturnEntityConvertedToDTO() {
		
		// given
		CategoryModel category = new CategoryModel();
		category.setCategory_name("Action");
		CategoryServiceImpl categoryService = new CategoryServiceImpl(categoryRepository);

		CategoryDTO categoryDTOSample = new CategoryDTO();
		categoryDTOSample.setCategory_name("Action");

		// when
		CategoryDTO categoryDTO = categoryService.convertEntityToDTO(category);

		// then
		
		// assertThat(category_name).isEqualTo(categoryDTO.getCategory_name());
		assertThat(categoryDTOSample).usingRecursiveComparison().isEqualTo(categoryDTO);

	}
	
	
}
