package com.springboot.videoservice.app.service;

import java.util.List;

import com.springboot.videoservice.app.model.ChannelPlayListModel;

public interface ChannelPlayListService {
   ChannelPlayListModel saveChannelPlayListModel(ChannelPlayListModel channelPlayList);
   List<ChannelPlayListModel> getAllChannelPlayLists();
   ChannelPlayListModel getChannelPlayListById(long id);
}
