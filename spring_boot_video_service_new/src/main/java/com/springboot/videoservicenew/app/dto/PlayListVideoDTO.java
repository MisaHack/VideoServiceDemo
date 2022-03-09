package com.springboot.videoservicenew.app.dto;

import java.util.List;

import lombok.Data;

@Data
public class PlayListVideoDTO {

   //by name Model Mapper know exactly which
   //Model field to map to which DTO field automaticaly
	
   private String playListName;
   private String videoName;
   
   private int playListOrderNumber;
   private int videoOrderNumber;
   
   
   
}
