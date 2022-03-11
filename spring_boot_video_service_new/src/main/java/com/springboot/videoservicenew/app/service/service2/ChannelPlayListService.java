package com.springboot.videoservicenew.app.service.service2;

import java.util.List;

import com.springboot.videoservicenew.app.model.ChannelPlayListModel;

public interface ChannelPlayListService {
   ChannelPlayListModel saveChannelPlayListModel(ChannelPlayListModel channelPlayList);
   List<ChannelPlayListModel> getAllChannelPlayLists();
   ChannelPlayListModel getChannelPlayListById(long id);
   ChannelPlayListModel updateChannelPlayList(ChannelPlayListModel channel, long id);
   void deleteChannelPlayList(long id);
}
