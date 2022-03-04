package com.springboot.videoservicenew.app.service.service2;

import java.util.List;

import com.springboot.videoservicenew.app.dto.ChannelDTO;
import com.springboot.videoservicenew.app.model.ChannelModel;

public interface ChannelService {
   ChannelModel saveChannel(ChannelModel channel);
   List<ChannelModel> getAllChannels();
   ChannelModel getChannelById(long id);
   ChannelModel updateChannel(ChannelModel channel, long id);
   void deleteChannel(long id);
   ChannelModel addPlayListToChannel(long play_list_id,long channel_id);
   void removePlayListFromChannel(long play_list_id,long channel_id);
   ChannelDTO convertEntityToDTO(ChannelModel channelModel);
   List<ChannelDTO> getAllChannelAsDTO();
   
}
