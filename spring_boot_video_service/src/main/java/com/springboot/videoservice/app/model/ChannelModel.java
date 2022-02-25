package com.springboot.videoservice.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Channel")
public class ChannelModel {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public long id;
   
   @Column(name="name")
   private String name;
   
   //fali PLAYLISTS - dodao sam ga 
   @OneToMany(mappedBy = "playListModel", cascade = CascadeType.ALL)
   Collection <ChannelPlayListModel> channelPlayLists = new ArrayList<>();
      
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
