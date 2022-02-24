package com.springboot.videoservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservice.app.model.ChannelModel;
import com.springboot.videoservice.app.service.ChannelService;

@RestController
@RequestMapping("/api/channels")
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	public ChannelController(ChannelService channelService) {
		super();
		this.channelService = channelService;
	}

	@PostMapping
	public ResponseEntity<ChannelModel> saveChannel(@RequestBody ChannelModel channel){
	   return new ResponseEntity<ChannelModel>(channelService.saveChannel(channel),HttpStatus.CREATED);
	}
}
