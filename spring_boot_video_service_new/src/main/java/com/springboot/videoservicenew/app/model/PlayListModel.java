package com.springboot.videoservicenew.app.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="PlayList")
public class PlayListModel {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "playList_id")
   public long id;
   
   @Column(name = "name")
   public String name;
   
   @Column(name = "orderNumber")
   public int orderNumber;
   
   //svaka PlayLista ima Kategoriju
   //@Column(name = "category")
   @JsonIgnore
   @ManyToMany
   @JoinTable(
	  name = "playlist_categories",
	  joinColumns = @JoinColumn(name = "playList_id"),
	  inverseJoinColumns = @JoinColumn(name = "category_id")
   )
   private Set<CategoryModel> categories_in_playlist = new HashSet<>();   
   
   //fali VIDEOS - dodat je na ovaj nacin
   @JsonIgnore
   //@OneToMany(mappedBy = "playListModel", cascade = {CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
   @OneToMany(mappedBy = "playListModel", cascade = CascadeType.ALL, orphanRemoval = true)
   //, orphanRemoval = true
   //@OrphanRemoval
   List<PlayListVideoModel> playListVideos = new ArrayList<>();
   
   /*@Column(name = "user")
   public UserModel user;*/
   
   //ovo je konekcija za Channel na Playlistu
   @JsonIgnore
   @OneToMany(mappedBy = "playListModel_c", cascade = CascadeType.ALL, orphanRemoval = true)   
   List<ChannelPlayListModel> channelPlayLists = new ArrayList<>();
   
   //ove metode add i remove sam isto naknadno dodao
   public void addVideo(VideoModel videoModel){
	   PlayListVideoModel playListVideo = new PlayListVideoModel(this, videoModel);
	   playListVideos.add(playListVideo);
	   //videoModel.getPlayListVideo().add(playListVideo);
   }
   //ove metode add i remove sam isto naknadno dodao
   public void removeVideo(VideoModel videoModel){
	  for(Iterator<PlayListVideoModel> iterator = playListVideos.iterator(); iterator.hasNext();){
		 PlayListVideoModel playListVideoModel = iterator.next();
		 
		 if(playListVideoModel.getVideoModel().equals(videoModel) && playListVideoModel.getPlayListModel().equals(this)){
			iterator.remove();
			playListVideoModel.getPlayListModel().getPlayListVideos().remove(playListVideoModel);
			//playListVideoModel.setPlayListModel(null);
			//playListVideoModel.setVideoModel(null);
		 }
	  }
	   
	   
	  /* System.out.println("Usli smo ovde, treba da obrisemo video.");
	   PlayListVideoModel v = playListVideos.stream().filter(p -> p.getVideoModel().equals(videoModel)).findFirst().orElse(null);
	   if(v == null) {
		   System.out.println("Usli smo ovde, v je null.");
		   return;
	   }

	   System.out.println("Dosli smo do brisanja videa.");
	   playListVideos.remove(v);
	   videoModel.getPlayListVideo().remove(v);*/
   }
   
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
