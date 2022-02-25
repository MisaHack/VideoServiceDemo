package com.springboot.videoservice.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.model.ChannelModel;
import com.springboot.videoservice.app.repository.ChannelRepository;
import com.springboot.videoservice.app.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService{

	private ChannelRepository channelRepository;
	
	public ChannelServiceImpl(){
	}
	
	public ChannelServiceImpl(ChannelRepository channelRepository) {
		super();
		this.channelRepository = channelRepository;
	}

	@Override
	public ChannelModel saveChannel(ChannelModel channel) {
	   return channelRepository.save(channel);
	}

	@Override
	public List<ChannelModel> getAllChannels() {
	   return channelRepository.findAll();
	}

}
