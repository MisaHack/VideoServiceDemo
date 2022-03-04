package com.springboot.videoservicenew.app.dto;

import java.util.List;

import lombok.Data;

@Data
public class PlayListVideoDTO {

   private String play_list_name;
   private List<String> video_name;
   
}
