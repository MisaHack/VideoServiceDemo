package com.springboot.videoservice.app.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.model.VideoModel;
import com.springboot.videoservice.app.repository.VideoRepository;
import com.springboot.videoservice.app.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	private VideoRepository videoRepository;

	public VideoServiceImpl(VideoRepository videoRepository) {
		super();
		this.videoRepository = videoRepository;
	}

	@Override
	public VideoModel saveVideo(VideoModel video) {
		return videoRepository.save(video);
	}

	
}
