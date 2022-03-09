package com.springboot.videoservicenew.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.videoservicenew.app.dto.CategoryDTO;
import com.springboot.videoservicenew.app.dto.ChannelDTO;
import com.springboot.videoservicenew.app.exception.ResourceNotFoundException;
import com.springboot.videoservicenew.app.model.CategoryModel;
import com.springboot.videoservicenew.app.model.ChannelModel;
import com.springboot.videoservicenew.app.model.PlayListModel;
import com.springboot.videoservicenew.app.repository.ChannelRepository;
import com.springboot.videoservicenew.app.repository.PlayListRepository;
import com.springboot.videoservicenew.app.service.service2.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService{
	
	//Mapping DTO to Entity, and vice versa
	private ModelMapper mapper;

	private ChannelRepository channelRepository;
	
	private PlayListRepository playListRepository;
	
	public ChannelServiceImpl(ChannelRepository channelRepository, PlayListRepository playListRepository) {
		this.channelRepository = channelRepository;
		this.playListRepository = playListRepository;
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
       existingChannel.setOrderNumber(channel.getOrderNumber());
	   //existingChannel.setChannelPlayLists(channel.getChannelPlayLists());
	   
	   //save existing Channel to DB
       channelRepository.save(existingChannel);
       
	   return existingChannel;
	}

	@Override
	public void deleteChannel(long id) {
	
	   // check whether a Channel exists in DB or not
	   channelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Channel", "id", id));
		
	   channelRepository.deleteById(id);
	}

	@Override
	public ChannelModel addPlayListToChannel(long play_list_id, long channel_id) {
		
		//we need to check does Play List with the given id exist in DB or not	
		PlayListModel existingPlayList = playListRepository.findById(play_list_id).orElseThrow(() -> new ResourceNotFoundException("PlayList", "id", play_list_id));
		 
		//we need to check does Channel with the given id exist in DB or not 
		ChannelModel existingChannel = channelRepository.findById(channel_id).orElseThrow(() -> new ResourceNotFoundException("Channel", "id", channel_id));
		
		existingChannel.addPlayList(existingPlayList);
		
		channelRepository.save(existingChannel);
		
		return existingChannel;
	}

	@Override
	public void removePlayListFromChannel(long play_list_id, long channel_id) {
	   
		//we need to check does Play List with the given id exist in DB or not
		PlayListModel existingPlayList = playListRepository.findById(play_list_id).orElseThrow(() -> new ResourceNotFoundException("PlayList", "id", play_list_id));
		
		//we need to check does Channel with the given id exist in DB or not
		ChannelModel existingChannel = channelRepository.findById(channel_id).orElseThrow(() -> new ResourceNotFoundException("Channel", "id", channel_id));
		
		existingChannel.removePlayList(existingPlayList);
		
		channelRepository.save(existingChannel);
	}

//	@Override
//	public ChannelDTO convertEntityToDTO(ChannelModel channelModel) {
//	       
//	   ChannelDTO channelDTO = new ChannelDTO();
//	       
//	   channelDTO.setChannel_name(channelModel.getName());
//	   
//	   return channelDTO;
//	}
	
	//converting Entity to DTO
	public ChannelDTO convertEntityToDTO(ChannelModel channelModel){
	   
		ChannelDTO channelDTO = mapper.map(channelModel, ChannelDTO.class);	
	   
	   return channelDTO;  
	   
	}
	
	//converting DTO to Entity
	public ChannelModel convertDTOToEntity(ChannelDTO channelDTO){
	   
		ChannelModel channel = mapper.map(channelDTO, ChannelModel.class);
	   
	   return channel;
	}

	@Override
	public List<ChannelDTO> getAllChannelAsDTO() {
	   
       List<ChannelModel> channels = channelRepository.findAll();
       
       List<ChannelDTO> channelsDTO = new ArrayList<>();
       
       ChannelServiceImpl channelSerImpl = new ChannelServiceImpl(channelRepository, playListRepository);
       
       for(int i=0; i < channels.size() ; i++){
    	  channelsDTO.add(channelSerImpl.convertEntityToDTO(channels.get(i)));
       }
       
       return channelsDTO;
	}

}
