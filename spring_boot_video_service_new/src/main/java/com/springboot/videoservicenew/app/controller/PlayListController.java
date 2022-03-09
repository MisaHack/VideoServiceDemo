package com.springboot.videoservicenew.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.videoservicenew.app.dto.PlayListDTO;
import com.springboot.videoservicenew.app.model.CategoryModel;
import com.springboot.videoservicenew.app.model.PlayListModel;
import com.springboot.videoservicenew.app.service.service2.PlayListService;

@RestController
@RequestMapping("/api/playlists")
public class PlayListController { //Controller depends on Service layer

	@Autowired
	private PlayListService playlistService;

	public PlayListController(PlayListService playlistService) {
		super();
		this.playlistService = playlistService;
	}
	
	// build CREATE PlayList REST API
	@PostMapping
	public ResponseEntity<PlayListModel> savePlayList(@RequestBody PlayListModel playList){
		return new ResponseEntity<PlayListModel>(playlistService.savePlayList(playList), HttpStatus.CREATED);
		
	}
	
	// build GET ALL PlayLists REST API, to return ALL PlayLists from DB
    @GetMapping
    public List<PlayListModel> getAllPlayLists(){
       return playlistService.getAllPlayLists();	
    }
    
    // build GET PlayList BY ID REST API, to return PlayList BY ID from DB
    // http://localhost:8080/api/playlists/1
    // this is dynamic path variable    
    @GetMapping("{id}")
    public ResponseEntity<PlayListModel> getPlayListById(@PathVariable("id") long playList_id){
       return new ResponseEntity<PlayListModel>(playlistService.getPlayListById(playList_id), HttpStatus.OK);
    }
    
    // build UPDATE PlayList Data REST API, to Update PlayList Data fields from DB
    // http://localhost:8080/api/playlists/1
    // we use ResponseEntity as a return type
    @PutMapping("{id}")
    public ResponseEntity<PlayListModel> updatePlayList(@PathVariable("id") long id, @RequestBody PlayListModel playList){
       return new ResponseEntity<PlayListModel>(playlistService.updatePlayList(playList, id), HttpStatus.OK);
    }
    
    // build DELETE PlayList Data REST API
    // http://localhost:8080/api/playlists/1    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePlayList(@PathVariable("id") long id){
    	
 	   //delete PlayList from DB
       playlistService.deletePlayList(id);
       
       return new ResponseEntity<String>("Play List deleted successfully !", HttpStatus.OK);
    }
    
	// build ADD_CATEGORY_TO_PLAY_LIST REST API, to add category to Play List
	// http://localhost:8080/api/playlists/1/category/1
	// we use ResponseEntity as a return type
    @PutMapping("/{play_list_id}/category/{category_id}")
    public ResponseEntity<PlayListModel> addCategoryToPlayList(@PathVariable("play_list_id") long play_list_id, @PathVariable("category_id") long category_id){
       return new ResponseEntity<PlayListModel>(playlistService.addCategoryToPlayList(play_list_id, category_id), HttpStatus.OK);
    }
    
	// build REMOVE_CATEGORY_FROM_PLAY_LIST REST API, to Remove Category from Play List
	// http://localhost:8080/api/playlists/1/category/1
	// we use String as a return type   
    @DeleteMapping("/{play_list_id}/category/{category_id}")
    public ResponseEntity<String> deleteCategoryFromPlayList(@PathVariable("play_list_id") long play_list_id, @PathVariable("category_id") long category_id){
    	
       //delete Category from Play List
       playlistService.deleteCategoryFromPlayList(play_list_id, category_id);
       
       return new ResponseEntity<String>("Category deleted successfully from Play List !", HttpStatus.OK);
    }
    
	// build ADD_VIDEO_TO_PLAY_LIST REST API, to add Video to Play List
	// http://localhost:8080/api/playlists/1/video/1
	// we use ResponseEntity as a return type
    @PutMapping("/{play_list_id}/video/{video_id}")
    public ResponseEntity<PlayListModel> addVideoToPlayList(@PathVariable("play_list_id") long play_list_id, @PathVariable("video_id") long video_id){
       return new ResponseEntity<PlayListModel>(playlistService.addVideoToPlayList(video_id, play_list_id), HttpStatus.OK);
    }
    
	// build REMOVE_VIDEO_FROM_PLAY_LIST REST API, to remove Video from Play List
	// http://localhost:8080/api/playlists/1/video/1
	// we use ResponseEntity as a return type
    @DeleteMapping("/{play_list_id}/video/{video_id}")
    public ResponseEntity<String> deleteVideoFromPlayList(@PathVariable("play_list_id") long play_list_id, @PathVariable("video_id") long video_id){
        
       // delete Video from Play List
       playlistService.removeVideoFromPlayList(video_id, play_list_id);
    	
       return new ResponseEntity<String>("Video deleted from Play List !", HttpStatus.OK);
    }   
    
	// build GET ALL Play List as DTO format REST API, to return ALL Play List from DB in DTO format	
    // http://localhost:8080/api/playlists/getAllPlayListAsDto
    // this is dynamic path variable    
    @GetMapping("/getAllPlayListAsDto")
	public List<PlayListDTO> getAllPlayListsAsDTO(){
		
	   return playlistService.getAllPlayListsAsDTO();
	   
	}
    
	// build GET_CATEGORY_FROM_PLAY_LIST REST API, to GET category FROM Play List
	// http://localhost:8080/api/playlists/1/category/1
	// we use ResponseEntity as a return type
    @GetMapping("/{play_list_id}/category/{category_id}")
    public CategoryModel getCategoryFromPlayList(@PathVariable("play_list_id") long play_list_id, @PathVariable("category_id") long category_id) {
       return playlistService.getCategoryFromPlayList(play_list_id, category_id);	
    }
}