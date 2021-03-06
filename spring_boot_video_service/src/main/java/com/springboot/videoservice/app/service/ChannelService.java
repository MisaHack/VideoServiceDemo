package com.springboot.videoservice.app.service;

import java.util.List;

import com.springboot.videoservice.app.model.ChannelModel;

public interface ChannelService {
   ChannelModel saveChannel(ChannelModel channel);
   List<ChannelModel> getAllChannels();
   ChannelModel getChannelById(long id);
   ChannelModel updateChannel(ChannelModel channel, long id);
   void deleteChannel(long id);
}
