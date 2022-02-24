package com.springboot.videoservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservice.app.model.PlayListModel;
import com.springboot.videoservice.app.service.PlayListService;

@RestController
@RequestMapping("/api/playlists")
public class PlayListController {

	@Autowired
	private PlayListService playlistService;

	public PlayListController(PlayListService playlistService) {
		super();
		this.playlistService = playlistService;
	}
	
	public ResponseEntity<PlayListModel> savePlayList(@RequestBody PlayListModel playList){
		return new ResponseEntity<PlayListModel>(playlistService.savePlayList(playList), HttpStatus.CREATED);
		
	}

}
