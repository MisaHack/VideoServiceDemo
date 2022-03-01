package com.springboot.videoservicenew.app.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Video")
public class VideoModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "video_id")
   public long id;
   
   @Column(name="name")
   public String name;
   
   @Column(name="orderNumber")
   public int orderNumber;
   
   //svaki Video ima Kategoriju
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(
      name = "video_categories",
      joinColumns = @JoinColumn(name = "video_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id")
   )
   private Set<CategoryModel> categories_in_video = new HashSet<>();
   
   //ovde treba kolekcija PlayListVideo
   //@OneToMany(mappedBy = "videoModel", cascade = CascadeType.ALL)
   //Collection<PlayListVideoModel> playListVideo = new ArrayList<>();
   
   //svaki video ima Kategoriju
   //@Column(name = "category")
   //Set<Category> category = new HashSet<>();
   
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
       VideoModel other = (VideoModel) obj;
       return Objects.equals(id, other.getId());
   }
}