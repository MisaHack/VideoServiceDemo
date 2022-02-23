package com.springboot.videoservice.app.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Channel")
public class Channel {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public String id;
   
   @Column(name="name")
   private String name;
   
   //fali PLAYLISTS
   
   public String getId() {
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
       Channel other = (Channel) obj;
       return Objects.equals(id, other.getId());
   }
}
