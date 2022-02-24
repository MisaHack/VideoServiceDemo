package com.springboot.videoservice.app.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.model.PlayListVideoModel;
import com.springboot.videoservice.app.repository.PlayListVideoRepository;
import com.springboot.videoservice.app.service.PlayListVideoService;

@Service
public class PlayListVideoServiceImpl implements PlayListVideoService {

	private PlayListVideoRepository playListVideoRepository;

	public PlayListVideoServiceImpl() {
		super();
	}

	public PlayListVideoServiceImpl(PlayListVideoRepository playListVideoRepository) {
		super();
		this.playListVideoRepository = playListVideoRepository;
	}

	@Override
	public PlayListVideoModel savePlayListVideo(PlayListVideoModel playListVideo) {
	   return playListVideoRepository.save(playListVideo);
	}
}
