package com.springboot.videoservice.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.exception.ResourceNotFoundException;
import com.springboot.videoservice.app.model.UserModel;
import com.springboot.videoservice.app.model.VideoModel;
import com.springboot.videoservice.app.repository.UserRepository;
import com.springboot.videoservice.app.repository.VideoRepository;
import com.springboot.videoservice.app.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	private VideoRepository videoRepository;
	
	public VideoServiceImpl() {
		super();
	}

	public VideoServiceImpl(VideoRepository videoRepository) {
		super();
		this.videoRepository = videoRepository;
	}

	@Override
	public VideoModel saveVideo(VideoModel video) {
		return videoRepository.save(video);
	}

	@Override
	public List<VideoModel> getAllVideos() {
	   return videoRepository.findAll();
	}

	@Override
	public VideoModel getVdeoById(long id) {
	   Optional<VideoModel> video = videoRepository.findById(id);
	   
	   if(video.isPresent()) {
		  return video.get(); 
	   }
	   else {
		  throw new ResourceNotFoundException("Video", "id", id); 
	   }
	}
}
