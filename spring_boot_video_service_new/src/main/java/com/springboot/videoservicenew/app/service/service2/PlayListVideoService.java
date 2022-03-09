package com.springboot.videoservicenew.app.service.service2;

import java.util.List;

import com.springboot.videoservicenew.app.dto.PlayListVideoDTO;
import com.springboot.videoservicenew.app.model.PlayListVideoModel;

public interface PlayListVideoService {
   PlayListVideoModel savePlayListVideo(PlayListVideoModel playListVideo);
   List<PlayListVideoModel> getAllPlayListVideos();
   PlayListVideoModel getPlayListVideoById(long id);
   PlayListVideoModel updatePlayListVideo(PlayListVideoModel playListVideo, long id);
   void deletePlayListVideo(long id);
   PlayListVideoDTO convertEntityToDTO(PlayListVideoModel playListVideoModel);
   PlayListVideoModel convertDTOToEntity(PlayListVideoDTO playListVideoDTO);
}
