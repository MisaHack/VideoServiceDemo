package com.springboot.videoservice.app.service;

import java.util.List;

import com.springboot.videoservice.app.model.UserModel;
import com.springboot.videoservice.app.model.VideoModel;

public interface VideoService {
   VideoModel saveVideo(VideoModel video);
   List<VideoModel> getAllVideos();
   VideoModel getVdeoById(long id);
}
