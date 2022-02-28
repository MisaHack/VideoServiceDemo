package com.springboot.videoservice.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Locale.Category;

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
@Table(name="PlayList")
public class PlayListModel {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public long id;
   
   @Column(name = "name")
   public String name;
   
   /*@Column(name = "user")
   public UserModel user;*/
   
   //fali VIDEOS - dodat je na ovaj nacin
   @OneToMany(mappedBy = "playListModel", cascade = CascadeType.ALL)
   Collection <PlayListVideoModel> playListVideos = new ArrayList<>();
   
   //ovo je konekcija za Channel na Playlistu
   @OneToMany(mappedBy = "channelModel", cascade = CascadeType.ALL)   
   Collection <ChannelPlayListModel> channelPlayLists = new ArrayList<>();
   
   @Column(name = "orderNumber")
   public int orderNumber;
   
   //svaki video ima Kategoriju
   @Column(name = "category")
   Set<Category> category = new HashSet<>();
   
   public long getId() {
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
       PlayListModel other = (PlayListModel) obj;
       return Objects.equals(id, other.getId());
   }
}
