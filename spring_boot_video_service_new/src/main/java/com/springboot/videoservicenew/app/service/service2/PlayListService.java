package com.springboot.videoservicenew.app.service.service2;

import java.util.List;

import com.springboot.videoservicenew.app.model.PlayListModel;

public interface PlayListService {
   PlayListModel savePlayList(PlayListModel playList);
   List<PlayListModel> getAllPlayLists();
   PlayListModel getPlayListById(long id);
   PlayListModel updatePlayList(PlayListModel playList, long id);
   void deletePlayList(long id);
   PlayListModel addCategoryToPlayList(long play_list_id, long category_id);
   void deleteCategoryFromPlayList(long play_list_id, long category_id);
}
