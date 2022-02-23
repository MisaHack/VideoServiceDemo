package com.springboot.videoservice.app;

import java.util.ArrayList;
import java.util.List;

public class Channel {

	public String id;
	public String name; 
	
	private List<PlayList> playlists;
	
	public Channel(String id, String name){
	   this.id=id;
	   this.name=name; 
	   
	   playlists = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PlayList> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<PlayList> playlists) {
		this.playlists = playlists;
	}
	
	public void addPlaylistToChannel(PlayList playlist){
	   playlists.add(playlist);
	}
	
	

}
