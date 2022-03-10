package com.springboot.videoservicenew.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="Categories")
public class CategoryModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "category_id")
   private long id;
   
   @Column(name = "category_name")
   private String category_name;
   
   //ovim se povezujemo sa Playlist-om
   //@ManyToMany(mappedBy = "categories_in_playlist")
   @JsonIgnore
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(
	  name = "playlist_categories",
	  joinColumns = @JoinColumn(name = "category_id"),
	  inverseJoinColumns = @JoinColumn(name = "playList_id")
   )
   private Set<PlayListModel> playLists;
   
   //ovim se povezujemo sa Videom
   @ManyToMany(mappedBy = "categories_in_video", fetch = FetchType.LAZY)
   private Set<VideoModel> videos;
   
   //dva konstruktora sam dodao za INTEGRATION test za PlayListControllerTest
   public CategoryModel(String category_name){
	  this.category_name = category_name; 
   }
   
   public CategoryModel(){
	   
   }
   
}
