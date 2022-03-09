package com.springboot.videoservicenew.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.videoservicenew.app.dto.PlayListVideoDTO;
import com.springboot.videoservicenew.app.exception.ResourceNotFoundException;
import com.springboot.videoservicenew.app.model.PlayListVideoModel;
import com.springboot.videoservicenew.app.repository.PlayListVideoRepository;
import com.springboot.videoservicenew.app.service.service2.PlayListVideoService;

@Service
public class PlayListVideoServiceImpl implements PlayListVideoService {

	//Mapping DTO to Entity, and vice versa
	private ModelMapper mapper;
	
	private PlayListVideoRepository playListVideoRepository;

	public PlayListVideoServiceImpl(PlayListVideoRepository playListVideoRepository) {
		this.playListVideoRepository = playListVideoRepository;
	}

	@Override
	public PlayListVideoModel savePlayListVideo(PlayListVideoModel playListVideo) {
	   return playListVideoRepository.save(playListVideo);
	}

	@Override
	public List<PlayListVideoModel> getAllPlayListVideos() {
	   return playListVideoRepository.findAll();
	}

	@Override
	public PlayListVideoModel getPlayListVideoById(long id) {
	   Optional<PlayListVideoModel> playListVideo = playListVideoRepository.findById(id);
	   
	   if(playListVideo.isPresent()){
		  return playListVideo.get(); 
	   }
	   else{
		  throw new ResourceNotFoundException("PlayListVideo","id",id);  
	   }
	}

	@Override
	public PlayListVideoModel updatePlayListVideo(PlayListVideoModel playListVideo, long id) {
	   
        //we need to check does PlayList with the given id exist in DB or not
		PlayListVideoModel existingPlayListVideo = playListVideoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlayListVideo", "id", id));
		
		existingPlayListVideo.setPlayListModel(playListVideo.getPlayListModel());
		
		existingPlayListVideo.setVideoModel(playListVideo.getVideoModel());
		
		//save existing Play List to DB
		playListVideoRepository.save(existingPlayListVideo);
		return existingPlayListVideo;
	}

	@Override
	public void deletePlayListVideo(long id) {
	   
	   // check whether a Play List exist in DB or not
	   playListVideoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlayListVideo", "id", id));
	   
	   playListVideoRepository.deleteById(id);
		
	}
	
	//converting Entity to DTO
	public PlayListVideoDTO convertEntityToDTO(PlayListVideoModel playListVideoModel){
	   
	   PlayListVideoDTO playListVideoDTO = mapper.map(playListVideoModel, PlayListVideoDTO.class);	
	   
	   return playListVideoDTO;  
	   
	}
	
	//converting DTO to Entity
	public PlayListVideoModel convertDTOToEntity(PlayListVideoDTO playListVideoDTO){
	   
	   PlayListVideoModel playListVideoModel = mapper.map(playListVideoDTO, PlayListVideoModel.class);
	   
	   return playListVideoModel;
	}
}
