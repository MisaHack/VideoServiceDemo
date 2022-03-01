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
   
   @Column(name = "category_name", nullable = false)
   private String category_name;
   
   @ManyToMany(mappedBy = "categories")
   private Set<PlayListModel> playLists;
   
}
