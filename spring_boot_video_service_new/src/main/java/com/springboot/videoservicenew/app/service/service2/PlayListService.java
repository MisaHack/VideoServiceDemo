package com.springboot.videoservicenew.app.service.service2;

import java.util.List;

import com.springboot.videoservicenew.app.dto.PlayListDTO;
import com.springboot.videoservicenew.app.dto.PlayListVideoDTO;
import com.springboot.videoservicenew.app.model.CategoryModel;
import com.springboot.videoservicenew.app.model.PlayListModel;
import com.springboot.videoservicenew.app.model.VideoModel;

public interface PlayListService {
   PlayListModel savePlayList(PlayListModel playList);
   List<PlayListModel> getAllPlayLists();
   PlayListModel getPlayListById(long id);
   PlayListModel updatePlayList(PlayListModel playList, long id);
   void deletePlayList(long id);
   PlayListModel addCategoryToPlayList(long play_list_id, long category_id);
   void deleteCategoryFromPlayList(long play_list_id, long category_id);
   PlayListModel addVideoToPlayList(long video_id, long play_list_id);
   void removeVideoFromPlayList(long video_id, long play_list_id);
   List<PlayListDTO> getAllPlayListsAsDTO();
   //List<PlayListVideoDTO> getAllPlayListVideoAsDTO();
   CategoryModel getCategoryFromPlayList(long play_list_id, long category_id);
   PlayListDTO convertEntityToDTO(PlayListModel playListModel);
   PlayListModel convertDTOToEntity(PlayListDTO playListDTO);
}
