package com.springboot.videoservice.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.exception.ResourceNotFoundException;
import com.springboot.videoservice.app.model.ChannelModel;
import com.springboot.videoservice.app.repository.ChannelRepository;
import com.springboot.videoservice.app.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService{

	private ChannelRepository channelRepository;
	
	public ChannelServiceImpl(ChannelRepository channelRepository) {
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

	@Override
	public ChannelModel getChannelById(long id) {
	   Optional<ChannelModel> channel = channelRepository.findById(id);
	   
	   if(channel.isPresent()){
		  return channel.get(); 
	   }
	   else{
		  throw new ResourceNotFoundException("Channel","id",id); 
	   }
	}

	@Override
	public ChannelModel updateChannel(ChannelModel channel, long id) {
	   
	   //we need to check does Channel with the given id exist in DB or not
	   ChannelModel existingChannel = channelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Channel","id",id));
	   
	   existingChannel.setName(channel.getName());
	   existingChannel.setChannelPlayLists(channel.getChannelPlayLists());
	   
	   //save existing Channel to DB
	   return existingChannel;
	}

	@Override
	public void deleteChannel(long id) {
	
	   // check whether a Channel exists in DB or not
	   channelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Channel", "id", id));
		
	   channelRepository.deleteById(id);
	}
	
	

}
