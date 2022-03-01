package com.springboot.videoservicenew.app.controller;

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

import com.springboot.videoservicenew.app.model.VideoModel;
import com.springboot.videoservicenew.app.service.service2.VideoService;

@RestController
@RequestMapping("/api/video")
public class VideoController { //Controller depends on Service layer

	@Autowired
	private VideoService videoService;

	public VideoController(VideoService videoService) {
		super();
		this.videoService = videoService;
	}

	// build CREATE Video REST API
	@PostMapping()
	public ResponseEntity<VideoModel> saveVideo(@RequestBody VideoModel video){
	   return new ResponseEntity<VideoModel>(videoService.saveVideo(video), HttpStatus.CREATED);	
	}
	
	// build GET ALL Videos REST API, to return ALL Videos from DB
	@GetMapping
	public List<VideoModel> getAllVideos(){
	   return videoService.getAllVideos();
	}

	// build GET Video BY ID REST API, to return Video BY ID from DB
	// http://localhost:8080/api/video/1
    // this is dynamic path variable
	@GetMapping("{id}")
	public ResponseEntity<VideoModel> getVideoById(@PathVariable("id") long video_id){
	   return new ResponseEntity<VideoModel>(videoService.getVideoById(video_id), HttpStatus.OK);	
	}
	
	
	// build UPDATE Video Data REST API, to Update Video Data fields from DB
	// http://localhost:8080/api/video/1
	// we use ResponseEntity as a return type
	@PutMapping("{id}")
	public ResponseEntity<VideoModel> updateVideo(@PathVariable("id") long id, @RequestBody VideoModel video){
	   return new ResponseEntity<VideoModel>(videoService.updateVideo(video, id), HttpStatus.OK);	
	}
	
	// build DELETE Video Data REST API
	// http://localhost:8080/api/video/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVideo(@PathVariable("id") long id){
		
	   //delete Video from DB
	   videoService.deleteVideo(id);
	   
	   return new ResponseEntity<String>("Video deleted successfully !", HttpStatus.OK);
	}
	
}
