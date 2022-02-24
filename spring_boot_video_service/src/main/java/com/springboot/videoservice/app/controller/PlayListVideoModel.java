package com.springboot.videoservice.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservice.app.service.PlayListVideoService;

@RestController
@RequestMapping("/api/playListVideos")
public class PlayListVideoModel {

	@Autowired
	private PlayListVideoService playListVideoService;

	public PlayListVideoModel(PlayListVideoService playListVideoService) {
		super();
		this.playListVideoService = playListVideoService;
	}
	
	@PostMapping
	public ResponseEntity<PlayListVideoModel> savePlayListVideo(@RequestBody PlayListVideoModel playListVideoModel){
	   return new ResponseEntity<PlayListVideoModel>(playListVideoService.savePlayListVideo(playListVideoModel), HttpStatus.CREATED);
	}

}
