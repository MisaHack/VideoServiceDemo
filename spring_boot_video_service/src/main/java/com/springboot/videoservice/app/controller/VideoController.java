package com.springboot.videoservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservice.app.model.VideoModel;
import com.springboot.videoservice.app.service.VideoService;

@RestController
@RequestMapping("/api/video")
public class VideoController {

	@Autowired
	private VideoService videoService;

	public VideoController(VideoService videoService) {
		super();
		this.videoService = videoService;
	}

	public ResponseEntity<VideoModel> saveVideo(@RequestBody VideoModel video){
	   return new ResponseEntity<VideoModel>(videoService.saveVideo(video), HttpStatus.CREATED);	
	}
}
