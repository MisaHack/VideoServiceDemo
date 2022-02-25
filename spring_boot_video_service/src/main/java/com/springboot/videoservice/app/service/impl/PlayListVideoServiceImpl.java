package com.springboot.videoservice.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.exception.ResourceNotFoundException;
import com.springboot.videoservice.app.model.PlayListVideoModel;
import com.springboot.videoservice.app.repository.PlayListVideoRepository;
import com.springboot.videoservice.app.service.PlayListVideoService;

@Service
public class PlayListVideoServiceImpl implements PlayListVideoService {

	private PlayListVideoRepository playListVideoRepository;

	public PlayListVideoServiceImpl() {
	}

	public PlayListVideoServiceImpl(PlayListVideoRepository playListVideoRepository) {
		super();
		this.playListVideoRepository = playListVideoRepository;
	}

	@Override
	public PlayListVideoModel savePlayListVideo(PlayListVideoModel playListVideo) {
	   return playListVideoRepository.save(playListVideo);
	}

	@Override
	public List<PlayListVideoModel> getAllPlayListVideos() {
	   return playListVideoRepository.findAll();
	}

	@Override
	public PlayListVideoModel getPlayListVideoById(long id) {
	   Optional<PlayListVideoModel> playListVideo = playListVideoRepository.findById(id);
	   
	   if(playListVideo.isPresent()){
		  return playListVideo.get(); 
	   }
	   else{
		  throw new ResourceNotFoundException("PlayListVideo","id",id);  
	   }
	}
}
