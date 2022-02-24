package com.springboot.videoservice.app.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PlayListVideoModel {
   
   @EmbeddedId
   private PlayListVideoId playListVideoId = new PlayListVideoId(); 
   
   @ManyToOne
   @MapsId("playListModelId")
   @JoinColumn(name = "playlistModel_id")
   private PlayListModel playListModel;
   
   @ManyToOne
   @MapsId("videoModelId")
   @JoinColumn(name = "videoModel_id")
   private VideoModel videoModel;
   
   //here we can add additional atribute that we add to the linking table
   //we also make getters and setters
   
   
}
