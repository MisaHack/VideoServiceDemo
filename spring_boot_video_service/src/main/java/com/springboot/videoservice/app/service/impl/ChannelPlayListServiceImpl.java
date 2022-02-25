package com.springboot.videoservice.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.exception.ResourceNotFoundException;
import com.springboot.videoservice.app.model.ChannelPlayListModel;
import com.springboot.videoservice.app.repository.ChannelPlayListRepository;
import com.springboot.videoservice.app.service.ChannelPlayListService;

@Service
public class ChannelPlayListServiceImpl implements ChannelPlayListService {

	private ChannelPlayListRepository channelPlayListRepository;
	
	

	public ChannelPlayListServiceImpl() {
		super();
	}

	public ChannelPlayListServiceImpl(ChannelPlayListRepository channelPlayListRepository) {
		super();
		this.channelPlayListRepository = channelPlayListRepository;
	}

	@Override
	public ChannelPlayListModel saveChannelPlayListModel(ChannelPlayListModel channelPlayList) {
		return channelPlayListRepository.save(channelPlayList);
	}

	@Override
	public List<ChannelPlayListModel> getAllChannelPlayLists() {
		return channelPlayListRepository.findAll();
	}

	@Override
	public ChannelPlayListModel getChannelPlayListById(long id) {
	   Optional<ChannelPlayListModel> channelPlayList = channelPlayListRepository.findById(id);
	   
	   if(channelPlayList.isPresent()){
		  return channelPlayList.get(); 
	   }
	   else{
		  throw new ResourceNotFoundException("ChannelPlayList", "id", id); 
	   }
	}

	@Override
	public ChannelPlayListModel updateChannelPlayList(ChannelPlayListModel channel, long id) {
		
       //we need to check does ChannelPlaylist with given id exist in DB or not
	   ChannelPlayListModel existingChannelPlaylist = channelPlayListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ChannelPlayList", "id", id));
	   
	   existingChannelPlaylist.setChannelModel(channel.getChannelModel());
	   existingChannelPlaylist.setPlayListModel(channel.getPlayListModel());
	   
	   //save existing ChannelPlayList to DB
	   channelPlayListRepository.save(existingChannelPlaylist);
	   return existingChannelPlaylist;
	   
	}

}
