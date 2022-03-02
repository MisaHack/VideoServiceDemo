package com.springboot.videoservicenew.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.videoservicenew.app.exception.ResourceNotFoundException;
import com.springboot.videoservicenew.app.model.CategoryModel;
import com.springboot.videoservicenew.app.model.PlayListModel;
import com.springboot.videoservicenew.app.repository.CategoryRepository;
import com.springboot.videoservicenew.app.repository.PlayListRepository;
import com.springboot.videoservicenew.app.service.service2.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService{

	private PlayListRepository playListRepository;
	
	private CategoryRepository categoryRepository;
	
	public PlayListServiceImpl(PlayListRepository playListRepository, CategoryRepository categoryRepository) {
		this.playListRepository = playListRepository;
		this.categoryRepository = categoryRepository;
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
	  
	   existingPlayList.getCategories_in_playlist().remove(existingCategory);
	   existingCategory.getPlayLists().remove(existingPlayList);
		
	}

}
