package com.springboot.videoservicenew.app.service.service2;

import java.util.List;

import com.springboot.videoservicenew.app.dto.VideoDTO;
import com.springboot.videoservicenew.app.model.VideoModel;

public interface VideoService {
   VideoModel saveVideo(VideoModel video);
   List<VideoModel> getAllVideos();
   VideoModel getVideoById(long id);
   VideoModel updateVideo(VideoModel video, long id);
   void deleteVideo(long id);
   VideoModel addCategoryToVideo(long video_id, long category_id);
   VideoDTO convertEntityToDTO(VideoModel videoModel);
   List<VideoDTO> getAllVideosAsDTO();
   VideoModel findByVideoName(String video_name);
}
