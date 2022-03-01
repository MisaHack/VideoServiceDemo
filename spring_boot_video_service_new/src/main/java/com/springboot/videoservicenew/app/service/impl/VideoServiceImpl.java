package com.springboot.videoservicenew.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.videoservicenew.app.exception.ResourceNotFoundException;
import com.springboot.videoservicenew.app.model.VideoModel;
import com.springboot.videoservicenew.app.repository.VideoRepository;
import com.springboot.videoservicenew.app.service.service2.VideoService;

import lombok.RequiredArgsConstructor;

@Service
public class VideoServiceImpl implements VideoService{

	private VideoRepository videoRepository;

	public VideoServiceImpl(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	@Override
	public VideoModel saveVideo(VideoModel video){
		return videoRepository.save(video);
	}

	@Override
	public List<VideoModel> getAllVideos() {
	   return videoRepository.findAll();
	}

	@Override
	public VideoModel getVideoById(long id) {
	   Optional<VideoModel> video = videoRepository.findById(id);
	   
	   if(video.isPresent()) {
		  return video.get(); 
	   }
	   else {
		  throw new ResourceNotFoundException("Video", "id", id); 
	   }
	}

	@Override
	public VideoModel updateVideo(VideoModel video, long id) {
	   
		//we need to check does Video with the given id exist in DB or not
		VideoModel existingVideo = videoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Video", "id", id));
		
		existingVideo.setName(video.getName());
		existingVideo.setOrderNumber(video.getOrderNumber());
		//existingVideo.setPlayListVideo(video.getPlayListVideo());
		//existingVideo.setCategory(video.getCategory());
		
		//save existing Video to DB
		videoRepository.save(existingVideo);
		return existingVideo;
	}

	@Override
	public void deleteVideo(long id) {
	
	   // check whether a Video exist in DB or not
	   videoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Video", "id", id));
	   
	   videoRepository.deleteById(id);
		
	}
}
