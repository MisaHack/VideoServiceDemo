package com.springboot.videoservice.app.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.videoservice.app.model.ChannelPlayListModel;
import com.springboot.videoservice.app.repository.ChannelPlayListRepository;
import com.springboot.videoservice.app.service.ChannelPlayListService;

@Service
public class ChannelPlayListServiceImpl implements ChannelPlayListService {

	private ChannelPlayListRepository channelPlayListRepository;

	public ChannelPlayListServiceImpl(ChannelPlayListRepository channelPlayListRepository) {
		super();
		this.channelPlayListRepository = channelPlayListRepository;
	}

	@Override
	public ChannelPlayListModel saveChannelPlayListModel(ChannelPlayListModel channelPlayList) {
		return channelPlayListRepository.save(channelPlayList);
	}

}
