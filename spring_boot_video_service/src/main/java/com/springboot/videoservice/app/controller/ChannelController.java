package com.springboot.videoservice.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservice.app.model.ChannelModel;
import com.springboot.videoservice.app.service.ChannelService;

@RestController
@RequestMapping("/api/channels")
public class ChannelController { //Controller depends on Service layer

	@Autowired
	private ChannelService channelService;

	public ChannelController(ChannelService channelService) {
		super();
		this.channelService = channelService;
	}

	// build CREATE Cheannel REST API
	@PostMapping
	public ResponseEntity<ChannelModel> saveChannel(@RequestBody ChannelModel channel){
	   return new ResponseEntity<ChannelModel>(channelService.saveChannel(channel),HttpStatus.CREATED);
	}
	
	// build GET ALL Channels REST API, to return ALL Channel from DB
	@GetMapping
	public List<ChannelModel> getAllChannels(){
	   return channelService.getAllChannels();	
	}
	
	// build GET Channel BY ID REST API, to return Channel BY ID from DB
	// http://localhost:8080/api/channel/1
	// this is dynamic path variable
	@GetMapping("{id}")
	public ResponseEntity<ChannelModel> getChannelById(@PathVariable("id") long channel_id){
	   return new ResponseEntity<ChannelModel>(channelService.getChannelById(channel_id),HttpStatus.OK);	
	}
	
	// build UPDATE Channel Data REST API, to Update Channel Data fields from DB
	// http://localhost:8080/api/channel/1
	// we use ResponseEntity as a return type
	public ResponseEntity<ChannelModel> updateChannel(@PathVariable("id") long id, @RequestBody ChannelModel channel){
	   return new ResponseEntity<ChannelModel>(channelService.updateChannel(channel, id), HttpStatus.OK);
	}
	
	// build DELETE Channel Data REST API
	// http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteChannel(@PathVariable("id") long id){
	   
	   //delete Channel from DB
	   channelService.deleteChannel(id);
	   
	   return new ResponseEntity<String>("Channel deleted successfully !", HttpStatus.OK);
	}
}
