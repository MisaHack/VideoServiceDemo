package com.springboot.videoservicenew.app.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="PlayListVideo")
public class PlayListVideoModel {
   
   @EmbeddedId
   private PlayListVideoModelKey playListVideoId = new PlayListVideoModelKey(); 
   
   @ManyToOne
   @MapsId("playListId")
   @JoinColumn(name = "play_list_id")
   private PlayListModel playListModel;
   
   @ManyToOne
   @MapsId("videoId")
   @JoinColumn(name = "video_id")
   private VideoModel videoModel;
   
   //here we can add additional atribute that we add to the linking table
   //we also make getters and setters
  
   private int some_additional_atribute;
   
}
