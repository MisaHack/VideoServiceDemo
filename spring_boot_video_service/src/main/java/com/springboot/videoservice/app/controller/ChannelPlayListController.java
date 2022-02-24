package com.springboot.videoservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservice.app.model.ChannelPlayListModel;
import com.springboot.videoservice.app.service.ChannelPlayListService;

@RestController
@RequestMapping("/api/channelPlayLists")
public class ChannelPlayListController {

	@Autowired
	private ChannelPlayListService channelPlayListService;

	public ChannelPlayListController(ChannelPlayListService channelPlayListService) {
		super();
		this.channelPlayListService = channelPlayListService;
	}
	
	public ResponseEntity<ChannelPlayListModel> saveChannelPlayListService(@RequestBody ChannelPlayListModel channelPlaylist){
	   return new ResponseEntity<ChannelPlayListModel>(channelPlayListService.saveChannelPlayListModel(channelPlaylist), HttpStatus.CREATED);	
	}

}
