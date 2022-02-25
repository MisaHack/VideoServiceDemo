package com.springboot.videoservice.app.service;

import java.util.List;

import com.springboot.videoservice.app.model.PlayListModel;

public interface PlayListService {
   PlayListModel savePlayList(PlayListModel playList);
   List<PlayListModel> getAllPlayLists();
   PlayListModel getPlayListById(long id);
}
