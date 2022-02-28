package com.springboot.videoservice.app.controller;


import java.util.List;

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

import com.springboot.videoservice.app.model.PlayListVideoModel;
import com.springboot.videoservice.app.service.PlayListVideoService;

@RestController
@RequestMapping("/api/playListVideos")
public class PlayListVideoController { //Controller depends on Service layer

	@Autowired
	private PlayListVideoService playListVideoService;

	public PlayListVideoController(PlayListVideoService playListVideoService) {
		super();
		this.playListVideoService = playListVideoService;
	}
	
	// build CREATE PlayListVideo REST API
	@PostMapping
	public ResponseEntity<PlayListVideoModel> savePlayListVideo(@RequestBody PlayListVideoModel playListVideo){
	   return new ResponseEntity<PlayListVideoModel>(playListVideoService.savePlayListVideo(playListVideo), HttpStatus.CREATED);
	}
	
	// build GET ALL PlayListVideo REST API, to return ALL PlayListVideo from DB
	@GetMapping
	public List<PlayListVideoModel> getAllPlayListVideos(){
	   return playListVideoService.getAllPlayListVideos();	
	}
	
	// build GET PlayListVideo BY ID REST API, to return PlayListVideo BY ID from DB
	// http://localhost:8080/api/playlistvideo/1
	// this is dynamic path variable	
	@GetMapping("{id}")
	public ResponseEntity<PlayListVideoModel> getPlayListVideoById(@PathVariable("id") long playListVideo_id){
	   return new ResponseEntity<PlayListVideoModel>(playListVideoService.getPlayListVideoById(playListVideo_id), HttpStatus.OK);	
	}
	
	// build UPDATE PlayListVideo Data REST API, to Update PlayListVideo Data fields from DB
	// http://localhost:8080/api/playListVideo/1
	// we use ResponseEntity as a return type	
	@PutMapping("{id}")
	public ResponseEntity<PlayListVideoModel> updatePlayListVideo(@PathVariable("id") long id, @RequestBody PlayListVideoModel playListVideo){
	   return new ResponseEntity<PlayListVideoModel>(playListVideoService.updatePlayListVideo(playListVideo, id), HttpStatus.OK);	
	}
	
	// build DELETE PlayListVideo Data REST API
	// http://localhost:8080/api/playListVideo/1	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePlayListVideo(@PathVariable("id") long id){
	   
	   //delete PlayListVideo from DB
	   playListVideoService.deletePlayListVideo(id);
	   
	   return new ResponseEntity<String>("PlayListVideo deleted successfully !", HttpStatus.OK);
	}
}
