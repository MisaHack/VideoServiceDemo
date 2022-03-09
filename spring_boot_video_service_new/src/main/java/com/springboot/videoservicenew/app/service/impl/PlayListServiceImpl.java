package com.springboot.videoservicenew.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.videoservicenew.app.dto.PlayListDTO;
import com.springboot.videoservicenew.app.exception.ResourceNotFoundException;
import com.springboot.videoservicenew.app.model.CategoryModel;
import com.springboot.videoservicenew.app.model.PlayListModel;
import com.springboot.videoservicenew.app.model.VideoModel;
import com.springboot.videoservicenew.app.repository.CategoryRepository;
import com.springboot.videoservicenew.app.repository.PlayListRepository;
import com.springboot.videoservicenew.app.repository.PlayListVideoRepository;
import com.springboot.videoservicenew.app.repository.VideoRepository;
import com.springboot.videoservicenew.app.service.service2.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService{

	//Mapping DTO to Entity, and vice versa
	private ModelMapper mapper;
	
	private PlayListRepository playListRepository;
	
	private CategoryRepository categoryRepository;
	
	private VideoRepository videoRepository;
	
	private PlayListVideoRepository playListVideoRepository;
	
	//U OVAJ KONSTRUKTOR MORAJU BITI DODATI SVI REPOSITORY OBJEKTI KOJE KORISTIMO ILI CE BACITI GRESKU KADA KORISTIMO NEKI OD NJIH A NISU MAPIRANI OVDE ! ! !
	public PlayListServiceImpl(PlayListRepository playListRepository, CategoryRepository categoryRepository, VideoRepository videoRepository) {
		this.playListRepository = playListRepository;
		this.categoryRepository = categoryRepository;
		this.videoRepository = videoRepository;
	}

	@Override
	public PlayListModel savePlayList(PlayListModel playList) {
		return playListRepository.save(playList);
	}

	@Override
	public List<PlayListModel> getAllPlayLists() {
	   return playListRepository.findAll();
	}

	@Override
	public PlayListModel getPlayListById(long id) {
	   Optional<PlayListModel> playList = playListRepository.findById(id);
	   
	   if(playList.isPresent()){
		  return playList.get(); 
	   }
	   else{
		  throw new ResourceNotFoundException("PlayList","id",id); 
	   }
	}

	@Override
	public PlayListModel updatePlayList(PlayListModel playList, long id) {
	   
	   //we need to check does PlayList with the given id exist in DB or not
	   PlayListModel existingPlayList = playListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlayList", "id", id));

	   existingPlayList.setName(playList.getName());
	   //existingPlayList.setChannelPlayLists(playList.getChannelPlayLists());
	   existingPlayList.setOrderNumber(playList.getOrderNumber());
	   //existingPlayList.setCategory(playList.getCategory());
	   
	   //save existing Play List to DB
	   playListRepository.save(existingPlayList);
	   return existingPlayList;
	}

	@Override
	public void deletePlayList(long id) {
	   // check whether a PlayList exist in DB or not
	   playListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlayList", "id", id));
	   
	   playListRepository.deleteById(id);
	}

	@Override
	public PlayListModel addCategoryToPlayList(long play_list_id, long category_id) {
	   
       //we need to check does Play List with the given id exist in DB or not	
	   PlayListModel existingPlayList = playListRepository.findById(play_list_id).orElseThrow(() -> new ResourceNotFoundException("PlayList", "id", play_list_id));
	   
	   //we need to check does Category with the given id exist in DB or not
	   CategoryModel existingCategory = categoryRepository.findById(category_id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", category_id));
	   
	   existingPlayList.getCategories_in_playlist().add(existingCategory);
	   
	   playListRepository.save(existingPlayList);
	   
	   return existingPlayList;
	}

	@Override
	public void deleteCategoryFromPlayList(long play_list_id, long category_id) {
	   
	   //we need to check does Play List with the given id exist in DB or not	
	   PlayListModel existingPlayList = playListRepository.findById(play_list_id).orElseThrow(() -> new ResourceNotFoundException("PlayList", "id", play_list_id));
		   
	   //we need to check does Category with the given id exist in DB or not
	   CategoryModel existingCategory = categoryRepository.findById(category_id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", category_id));
	  
	   //for(CategoryModel category : existingPlayList.getCategories_in_playlist()){
		 //   
		  //existingPlayList.remove(category);
	   //}
	   
	   existingPlayList.getCategories_in_playlist().remove(existingCategory);
	   
	   playListRepository.save(existingPlayList);

	}
	
	@Override
	public CategoryModel getCategoryFromPlayList(long play_list_id, long category_id){
	  
	   //we need to check does Play List with the given id exist in DB or not	
	   PlayListModel existingPlayList = playListRepository.findById(play_list_id).orElseThrow(() -> new ResourceNotFoundException("PlayList", "id", play_list_id));
			   
	   //we need to check does Category with the given id exist in DB or not
	   CategoryModel existingCategory = categoryRepository.findById(category_id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", category_id));
	   
	   Set<CategoryModel> categories = existingPlayList.getCategories_in_playlist();
	   
	   CategoryModel categoryModel = null;
	   
	   for(CategoryModel category : categories){
		  if(category.getId() == category_id){
			 categoryModel = category;
		  }
	   }
	   
	   return categoryModel;
	   
	}

	@Override
	public PlayListModel addVideoToPlayList(long video_id, long play_list_id) {

	     //we need to check does Play List with the given id exist in DB or not	
		 PlayListModel existingPlayList = playListRepository.findById(play_list_id).orElseThrow(() -> new ResourceNotFoundException("PlayList", "id", play_list_id));
	   
		 System.out.println(existingPlayList.toString());
		 
		 //we need to check does Video with the given id exist in DB or not
		 VideoModel existingVideo = videoRepository.findById(video_id).orElseThrow(() -> new ResourceNotFoundException("Video", "id", video_id));
		 
		 System.out.println(existingVideo.toString());
		 
		 existingPlayList.addVideo(existingVideo);
		 
		 playListRepository.save(existingPlayList);
		 
		 return existingPlayList;
	}

	@Override
	public void removeVideoFromPlayList(long video_id, long play_list_id) {
	   
	     //we need to check does Play List with the given id exist in DB or not	
		 PlayListModel existingPlayList = playListRepository.findById(play_list_id).orElseThrow(() -> new ResourceNotFoundException("PlayList", "id", play_list_id));
		 
		 //we need to check does Video with the given id exist in DB or not
		 VideoModel existingVideo = videoRepository.findById(video_id).orElseThrow(() -> new ResourceNotFoundException("Video", "id", video_id));
		 
		 
		//---------------------------------------------------
//		 System.out.println("Usli smo ovde, treba da obrisemo video.");
//		 PlayListVideoModel v = existingPlayList.getPlayListVideos().stream().filter(p -> p.getVideoModel().equals(existingVideo)).findFirst().orElse(null);
//		 System.out.println(v.getVideoModel().getId() + " >>>>> " + v.getPlayListModel().getId() );
//		 if(v == null) {
//			   System.out.println("Usli smo ovde, v je null.");
//			   return;
//		   }
//
//		 System.out.println(existingPlayList.getPlayListVideos().get(0).getVideoModel().getId() + "PREPREPRE<<<<<<<<<<<<<<<<<<<<<<");
//		   System.out.println("Dosli smo do brisanja videa.");
//		   existingPlayList.getPlayListVideos().remove(v);
		   
		   //---------------------------------------------------
		   
		   //System.out.println(existingPlayList.getPlayListVideos().get(0).getVideoModel().getId() + "<<<<<<<<<<<<<<<<<<<<<<");
		   //existingVideo.getPlayListVideo().remove(v);
		 existingPlayList.removeVideo(existingVideo);
		 
		 playListRepository.save(existingPlayList);
		// videoRepository.save(existingVideo);
		 
	}

	//Service for converting Play List Entity to Play List with less data
//	@Override
//	public PlayListDTO convertEntityToDTO(PlayListModel playListModel) {
//       
//	   PlayListDTO playListDTO = new PlayListDTO();
//	   
//	   playListDTO.setPlay_list_name(playListModel.getName());
//	   
//	   return playListDTO;
//	}

	@Override
	public List<PlayListDTO> getAllPlayListsAsDTO() {
	   
	   List<PlayListModel> playLists = playListRepository.findAll();
	   
	   List<PlayListDTO> playListsDTO = new ArrayList<>();
	   
	   PlayListServiceImpl playListSerImpl = new PlayListServiceImpl(playListRepository, categoryRepository, videoRepository);
	   
	   for(int i=0; i < playLists.size() ; i++){
		  playListsDTO.add(playListSerImpl.convertEntityToDTO(playLists.get(i))); 
	   }
	   
	   return playListsDTO;
	}

//	@Override
//	public PlayListVideoDTO convertPlayListVideoToDTO(PlayListModel playListModel, VideoModel videoModel) {
//
//       PlayListVideoDTO playListVideoDTO = new PlayListVideoDTO();
//       
//       playListVideoDTO.setPlay_list_name(playListModel.getName());
//       
//       for(int i=0 ; i < videoModel.getPlayListVideo().size(); i++) {
//           playListVideoDTO.getVideo_name().add(videoModel.getName());
//       }
//       
//       return playListVideoDTO;
//       
//	}

//	@Override
//	public List<PlayListVideoDTO> getAllPlayListVideoAsDTO() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	//converting Entity to DTO
	public PlayListDTO convertEntityToDTO(PlayListModel playListModel){
	   
		PlayListDTO playListDTO = mapper.map(playListModel, PlayListDTO.class);	
	   
	   return playListDTO;  
	   
	}
	
	//converting DTO to Entity
	public PlayListModel convertDTOToEntity(PlayListDTO playListDTO){
	   
		PlayListModel playList = mapper.map(playListDTO, PlayListModel.class);
	   
	   return playList;
	}
	
}
