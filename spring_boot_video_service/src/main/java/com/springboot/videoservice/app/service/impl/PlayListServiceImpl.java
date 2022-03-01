package com.springboot.videoservice.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.exception.ResourceNotFoundException;
import com.springboot.videoservice.app.model.PlayListModel;
import com.springboot.videoservice.app.repository.PlayListRepository;
import com.springboot.videoservice.app.service.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService{

	private PlayListRepository playListRepository;
	
	public PlayListServiceImpl(PlayListRepository playListRepository) {
		this.playListRepository = playListRepository;
	}

	@Override
	public PlayListModel savePlayList(PlayListModel playList) {
		return playListRepository.save(playList);
	}

	@Override
	public List<PlayListModel> getAllPlayLists() {
	   return playListRepository.findAll();
	}

	@Override
	public PlayListModel getPlayListById(long id) {
	   Optional<PlayListModel> playList = playListRepository.findById(id);
	   
	   if(playList.isPresent()){
		  return playList.get(); 
	   }
	   else{
		  throw new ResourceNotFoundException("PlayList","id",id); 
	   }
	}

	@Override
	public PlayListModel updatePlayList(PlayListModel playList, long id) {
	   
	   //we need to check does PlayList with the given id exist in DB or not
	   PlayListModel existingPlayList = playListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlayList", "id", id));

	   existingPlayList.setName(playList.getName());
	   existingPlayList.setChannelPlayLists(playList.getChannelPlayLists());
	   existingPlayList.setOrderNumber(playList.getOrderNumber());
	   existingPlayList.setCategory(playList.getCategory());
	   
	   //save existing Play List to DB
	   playListRepository.save(existingPlayList);
	   return existingPlayList;
	}

	@Override
	public void deletePlayList(long id) {
	   // check whether a PlayList exist in DB or not
	   playListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlayList", "id", id));
	   
	   playListRepository.deleteById(id);
	}

}
