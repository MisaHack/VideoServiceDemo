package com.springboot.videoservicenew.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="Channel")
public class ChannelModel {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "channel_id")
   public long id;
   
   @Column(name="name")
   private String name;
   
   @Column(name="orderNumber")
   private int orderNumber;
   
   //fali PLAYLISTS - dodao sam ga 
   @JsonIgnore
   @OneToMany(mappedBy = "channelModel", cascade = CascadeType.ALL, orphanRemoval = true)
   Collection <ChannelPlayListModel> channelPlayLists = new ArrayList<>();
      
   //add PlayList to Channel
   public void addPlayList(PlayListModel playListModel){
	  ChannelPlayListModel channelPlayList = new ChannelPlayListModel(this, playListModel);
	  channelPlayLists.add(channelPlayList);
   }
   
   //remove PlayList from Channel
   public void removePlayList(PlayListModel playListModel){
	  for(Iterator<ChannelPlayListModel> iterator = channelPlayLists.iterator(); iterator.hasNext();){
		  ChannelPlayListModel channelPlayListModel = iterator.next();
		  
		  if(channelPlayListModel.getPlayListModel_c().equals(playListModel) && channelPlayListModel.getChannelModel().equals(this)){
			 iterator.remove();
			 channelPlayListModel.getChannelModel().getChannelPlayLists();
		  }
	  } 
   }
   
   public long getId(){
	  return id;
   }
   
   @Override
   public int hashCode() {
       return Objects.hashCode(id);
   }

   @Override
   public boolean equals(Object obj) {
       if (this == obj)
           return true;
       if (obj == null)
           return false;
       if (getClass() != obj.getClass())
           return false;
       ChannelModel other = (ChannelModel) obj;
       return Objects.equals(id, other.getId());
   }
}
