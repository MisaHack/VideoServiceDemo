package com.springboot.videoservicenew.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
   @ManyToMany(mappedBy = "categories_in_playlist")
   private Set<PlayListModel> playLists;
   
   //ovim se povezujemo sa Videom
   @ManyToMany(mappedBy = "categories_in_video")
   private Set<VideoModel> videos;
   
}
