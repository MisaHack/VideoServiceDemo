package com.springboot.videoservice.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.model.VideoModel;
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
}
