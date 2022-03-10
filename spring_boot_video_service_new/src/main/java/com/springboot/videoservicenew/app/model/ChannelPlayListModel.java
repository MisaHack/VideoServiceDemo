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
@Table(name="channelPlayList")
public class ChannelPlayListModel {
	
   @EmbeddedId
   private ChannelPlayListModelKey channelPlayListId;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @MapsId("channelId")
   @JoinColumn(name = "channel_id")
   private ChannelModel channelModel;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @MapsId("playListId")
   @JoinColumn(name = "playList_id")
   private PlayListModel playListModel_c;
   
   //here we can add additional atribute that we add to the linking table
   //we also make getters and setters   
   
   //private int some_additional_atribute - in our case we want order number;
   private int order_number;
   
   //treba nam prazan default konstruktor
   public ChannelPlayListModel(){
	
   }
   
   //dodajemo jos jedan konstruktor sa parametrima
   public ChannelPlayListModel(ChannelModel channel, PlayListModel playList){
	  this.channelModel = channel;
	  this.playListModel_c = playList;
	  this.channelPlayListId = new ChannelPlayListModelKey(channel.getId(), playList.getId());
   }
}
