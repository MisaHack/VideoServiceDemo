package com.springboot.videoservice.app.service;

import java.util.List;

import com.springboot.videoservice.app.model.PlayListModel;
import com.springboot.videoservice.app.model.PlayListVideoModel;

public interface PlayListVideoService {
   PlayListVideoModel savePlayListVideo(PlayListVideoModel playListVideo);
   List<PlayListVideoModel> getAllPlayListVideos();
   PlayListVideoModel getPlayListVideoById(long id);
}
