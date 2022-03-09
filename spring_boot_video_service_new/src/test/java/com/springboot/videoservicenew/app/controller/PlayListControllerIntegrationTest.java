package com.springboot.videoservicenew.app.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.videoservicenew.app.SpringBootVideoServiceNewApplication;
import com.springboot.videoservicenew.app.model.CategoryModel;

//INTEGRATION TEST

//@RunWith, @SpringBootTest, @LocalServerPort - are enough to fire up context

//spring boot app needs spring context - SpringRunner
//launches small test context for running spring based applications
@RunWith(SpringRunner.class)
//@SpringBootTest - says which application should we run, it is launching spring boot app
//SpringBootTest.WebEnvironment.RANDOM_PORT - it makes dynamic port for integration testing
@SpringBootTest(classes = SpringBootVideoServiceNewApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayListControllerIntegrationTest {

    //we autowire port here - so we can make URL
    @LocalServerPort
    private int port;

    //we want to fire a request to URI - we do that using RestTemplate
    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    private String createURLWithPort(String uri){
        return "http://localhost:" + port + uri;
    }

    @Test
    public void testRecieveVideoCategory() throws JSONException{
    	
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/playlists/1/category/1"), 
                HttpMethod.GET, 
                entity, 
                String.class
        );

        String expected = "{id:1, category_name:Horror}";

        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    @Test
    public void addCategoryToPlayList(){

        CategoryModel category = new CategoryModel("Action");
        
        HttpEntity<CategoryModel> entity = new HttpEntity<CategoryModel>(category, headers);
        
        ResponseEntity<String> response = restTemplate.exchange(
        		createURLWithPort("/api/playlists/1/category/1"), 
        		HttpMethod.PUT,
        		entity,
        		String.class
        );
        
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        
        assertTrue(actual.contains("/api/playlists/1/category/1"));
    }

}