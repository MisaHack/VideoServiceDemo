package com.springboot.videoservicenew.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.videoservicenew.app.dto.PlayListDTO;
import com.springboot.videoservicenew.app.dto.VideoDTO;
import com.springboot.videoservicenew.app.exception.ResourceNotFoundException;
import com.springboot.videoservicenew.app.model.CategoryModel;
import com.springboot.videoservicenew.app.model.PlayListModel;
import com.springboot.videoservicenew.app.model.VideoModel;
import com.springboot.videoservicenew.app.repository.CategoryRepository;
import com.springboot.videoservicenew.app.repository.VideoRepository;
import com.springboot.videoservicenew.app.service.service2.VideoService;

import lombok.RequiredArgsConstructor;

@Service
public class VideoServiceImpl implements VideoService{
	
	//Mapping DTO to Entity, and vice versa
	private ModelMapper mapper;

	private VideoRepository videoRepository;
	
	private CategoryRepository categoryRepository;

	public VideoServiceImpl(VideoRepository videoRepository, CategoryRepository categoryRepository) {
		this.videoRepository = videoRepository;
		this.categoryRepository = categoryRepository;

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

	@Override
	public VideoModel addCategoryToVideo(long video_id, long category_id) {
		
		//we need to check does Video with the given id exist in DB or not	
		VideoModel existingVideo = videoRepository.findById(video_id).orElseThrow(() -> new ResourceNotFoundException("Video","id",video_id));
		
		//we need to check does Category with the given id exist in DB or not	
		CategoryModel existingCategory = categoryRepository.findById(category_id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", category_id));
		
		existingVideo.getCategories_in_video().add(existingCategory);
		
		videoRepository.save(existingVideo);
		
		return existingVideo;
	}

	//Service for converting Video Entity to Video with less data
//	@Override
//	public VideoDTO convertEntityToDTO(VideoModel videoModel) {
//
//	   VideoDTO videoDTO = new VideoDTO();
//	   
//	   videoDTO.setVideo_name(videoModel.getName());
//	   
//	   return videoDTO;
//	}

	@Override
	public List<VideoDTO> getAllVideosAsDTO() {
	  
	   List<VideoModel> videos = videoRepository.findAll();
	   
	   List<VideoDTO> videosDTO = new ArrayList<>();
	   
	   VideoServiceImpl vidSerImpl = new VideoServiceImpl(videoRepository, categoryRepository);
	   
	   for(int i=0; i < videos.size() ; i++){
		  videosDTO.add(vidSerImpl.convertEntityToDTO(videos.get(i))); 
	   }
	   
	   return videosDTO;
	   
	}

	//Service for Testing by Video name
	@Override
	public VideoModel findByVideoName(String video_name) {
		// TODO Auto-generated method stub
		Optional<VideoModel> video = videoRepository.findVideoByName(video_name);
		
	    if(video.isPresent()) {
           return video.get(); 
	    }
		else {
		   throw new ResourceNotFoundException("Video", "video_name", video_name); 
 	    }
	}
	
	//converting Entity to DTO
	public VideoDTO convertEntityToDTO(VideoModel videoModel){
	   
	   VideoDTO videoDTO = mapper.map(videoModel, VideoDTO.class);	
	   
	   return videoDTO;  
	   
	}
	
	//converting DTO to Entity
	public VideoModel convertDTOToEntity(VideoDTO videoDTO){
	   
	   VideoModel video = mapper.map(videoDTO, VideoModel.class);
	   
	   return video;
	}
}
