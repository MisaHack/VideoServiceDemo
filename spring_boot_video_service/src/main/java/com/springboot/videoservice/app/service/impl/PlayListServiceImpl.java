package com.springboot.videoservice.app.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.model.PlayListModel;
import com.springboot.videoservice.app.repository.PlayListRepository;
import com.springboot.videoservice.app.service.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService{

	private PlayListRepository playListRepository;
	
	public PlayListServiceImpl(PlayListRepository playListRepository) {
		super();
		this.playListRepository = playListRepository;
	}

	@Override
	public PlayListModel savePlayList(PlayListModel playList) {
		return playListRepository.save(playList);
	}

}
