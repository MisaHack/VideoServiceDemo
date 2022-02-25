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
	
	public PlayListServiceImpl(){
		
	}
	
	public PlayListServiceImpl(PlayListRepository playListRepository) {
		super();
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

}
