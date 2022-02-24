package com.springboot.videoservice.app.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ChannelPlayListModel {
	
   @EmbeddedId
   private ChannelPlayListId channelPlayListId = new ChannelPlayListId();
   
   @ManyToOne
   @MapsId("channelModelId")
   @JoinColumn(name = "channelModel_id")
   private ChannelModel channelModel;
   
   @ManyToOne
   @MapsId("playListModelId")
   @JoinColumn(name = "playListModel_id")
   private PlayListModel playListModel;
   
   //here we can add additional atribute that we add to the linking table
   //we also make getters and setters   
}
