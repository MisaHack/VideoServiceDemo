package com.springboot.videoservicenew.app.model;

import java.util.HashSet;
import java.util.Locale.Category;
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
@Table(name="PlayList")
public class PlayListModel {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "playList_id")
   public long id;
   
   @Column(name = "name")
   public String name;
   
   /*@Column(name = "user")
   public UserModel user;*/
   
   //fali VIDEOS - dodat je na ovaj nacin
   //@OneToMany(mappedBy = "playListModel", cascade = CascadeType.ALL)
   //Collection <PlayListVideoModel> playListVideos = new ArrayList<>();
   
   //ovo je konekcija za Channel na Playlistu
   //@OneToMany(mappedBy = "channelModel", cascade = CascadeType.ALL)   
   //Collection <ChannelPlayListModel> channelPlayLists = new ArrayList<>();
   
   @Column(name = "orderNumber")
   public int orderNumber;
   
   //svaki video ima Kategoriju
   //@Column(name = "category")
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(
	  name = "playlists_categories",
	  joinColumns = @JoinColumn(name = "playList_id"),
	  inverseJoinColumns = @JoinColumn(name = "category_id")
   )
   private Set<CategoryModel> categories = new HashSet<>();
   
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
