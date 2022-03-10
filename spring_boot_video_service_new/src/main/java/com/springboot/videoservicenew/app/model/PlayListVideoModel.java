package com.springboot.videoservicenew.app.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
   private PlayListVideoModelKey playListVideoId ;
   //= new PlayListVideoModelKey(); 
   //ovo sam isto naknadno zakomentarisao
   
   @ManyToOne(fetch = FetchType.LAZY)
   @MapsId("playListId")
   @JoinColumn(name = "play_list_id")
   private PlayListModel playListModel;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @MapsId("videoId")
   @JoinColumn(name = "video_id")
   private VideoModel videoModel;
   
   //here we can add additional atribute that we add to the linking table
   //we also make getters and setters
  
   //private int some_additional_atribute - in our case we want order number;
   private int order_number;
   
   //ovo je prazan konstruktor koji sam naknadno dodao
   public PlayListVideoModel() {
	   
   }
   
   //ovo sam naknadno dodao konstruktor
   public PlayListVideoModel(PlayListModel playList, VideoModel video){
	  this.playListModel=playList;
	  this.videoModel=video;
	  this.playListVideoId = new PlayListVideoModelKey(playList.getId(), video.getId());
   }
   
}
