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

import com.springboot.videoservicenew.app.model.PlayListModel;
import com.springboot.videoservicenew.app.service.service2.PlayListService;

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
	
	// build GET ALL PlayLists REST API, to return ALL PlayLists from DB
    @GetMapping
    public List<PlayListModel> getAllPlayLists(){
       return playlistService.getAllPlayLists();	
    }
    
    // build GET PlayList BY ID REST API, to return PlayList BY ID from DB
    // http://localhost:8080/api/playlist/1
    // this is dynamic path variable    
    @GetMapping("{id}")
    public ResponseEntity<PlayListModel> getPlayListById(@PathVariable("id") long playList_id){
       return new ResponseEntity<PlayListModel>(playlistService.getPlayListById(playList_id), HttpStatus.OK);
    }
    
    // build UPDATE PlayList Data REST API, to Update PlayList Data fields from DB
    // http://localhost:8080/api/playlist/1
    // we use ResponseEntity as a return type
    @PutMapping("{id}")
    public ResponseEntity<PlayListModel> updatePlayList(@PathVariable("id") long id, @RequestBody PlayListModel playList){
       return new ResponseEntity<PlayListModel>(playlistService.updatePlayList(playList, id), HttpStatus.OK);
    }
    
    // build DELETE PlayList Data REST API
    // http://localhost:8080/api/playlist/1    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePlayList(@PathVariable("id") long id){
    	
 	   //delete PlayList from DB
       playlistService.deletePlayList(id);
       
       return new ResponseEntity<String>("Play List deleted successfully !", HttpStatus.OK);
    }
    
}