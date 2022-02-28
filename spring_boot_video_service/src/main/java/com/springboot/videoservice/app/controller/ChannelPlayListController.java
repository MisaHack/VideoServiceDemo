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

import com.springboot.videoservice.app.model.ChannelPlayListModel;
import com.springboot.videoservice.app.service.ChannelPlayListService;

@RestController
@RequestMapping("/api/channelPlayLists")
public class ChannelPlayListController { //Controller depends on Service layer

	@Autowired
	private ChannelPlayListService channelPlayListService;

	public ChannelPlayListController(ChannelPlayListService channelPlayListService) {
		super();
		this.channelPlayListService = channelPlayListService;
	}
	
	// build CREATE ChannelPlayList REST API
	@PostMapping
	public ResponseEntity<ChannelPlayListModel> saveChannelPlayListService(@RequestBody ChannelPlayListModel channelPlaylist){
	   return new ResponseEntity<ChannelPlayListModel>(channelPlayListService.saveChannelPlayListModel(channelPlaylist), HttpStatus.CREATED);	
	}
	
	// build GET ALL ChannelPlayLists REST API, to return ALL ChannelPlayLists from DB
	@GetMapping
	public List<ChannelPlayListModel> getAllChannelPlayLists(){
       return channelPlayListService.getAllChannelPlayLists();		
	}
	
	// build GET ChannelPlayList BY ID REST API, to return ChannelPlayList BY ID from DB
	// http://localhost:8080/api/channelPlayList/1
	// this is dynamic path variable	
	@GetMapping("{id}")
	public ResponseEntity<ChannelPlayListModel> getChannelPlayListById(@PathVariable("id") long channelPlayList_id){
       return new ResponseEntity<ChannelPlayListModel>(channelPlayListService.getChannelPlayListById(channelPlayList_id), HttpStatus.OK);		
	}
	
	// build UPDATE ChannelPlayList Data REST API, to Update ChannelPlayList Data fields from DB
	// http://localhost:8080/api/channelPlayList/1
	// we use ResponseEntity as a return type	
	@PutMapping("{id}")
	public ResponseEntity<ChannelPlayListModel> updateChannelPlayList(@PathVariable("id") long id, @RequestBody ChannelPlayListModel channelPlayList){
	   return new ResponseEntity<ChannelPlayListModel>(channelPlayListService.updateChannelPlayList(channelPlayList, id), HttpStatus.OK);
	}
	
    // build DELETE ChannelPlayList Data REST API
	// http://localhost:8080/api/channelPlayList/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteChannelPlayList(@PathVariable("id") long id){
	   
	   //delete ChannelPlayList from DB
	   channelPlayListService.deleteChannelPlayList(id);
	   
	   return new ResponseEntity<String>("ChannelPlayList deleted successfully !", HttpStatus.OK);
	}
	
}
