package com.springboot.videoservice.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservice.app.model.PlayListModel;
import com.springboot.videoservice.app.service.PlayListService;

@RestController
@RequestMapping("/api/playlists")
public class PlayListController { //Controller depends on Service layer

	@Autowired
	private PlayListService playlistService;

	public PlayListController(PlayListService playlistService) {
		super();
		this.playlistService = playlistService;
	}
	
	// build CREATE PlayList REST API
	@PostMapping
	public ResponseEntity<PlayListModel> savePlayList(@RequestBody PlayListModel playList){
		return new ResponseEntity<PlayListModel>(playlistService.savePlayList(playList), HttpStatus.CREATED);
		
	}
	
	// build GET ALL PlayLists REST API, to return ALL Channel from DB
    @GetMapping
    public List<PlayListModel> getAllPlayLists(){
       return playlistService.getAllPlayLists();	
    }
}
