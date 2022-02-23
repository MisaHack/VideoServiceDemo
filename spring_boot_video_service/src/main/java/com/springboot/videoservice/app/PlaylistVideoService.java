 package com.springboot.videoservice.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlaylistVideoService {
	
	public static void addPlayListToChannel(BufferedReader input, List<PlayList> playlists, List<Channel> channels) throws NumberFormatException, IOException{
		
		  boolean channelExists = true;
		  
		  while(channels.isEmpty()){
			 System.err.println("There are no available Channels !"); 
			 System.err.println("Do you want to create one ? Y/N");
			 
			 String answer = input.readLine();
			 
			 if(answer.equalsIgnoreCase("Y")){
				System.err.println("Enter the name of the Channel : ");
				Channel channel = new Channel("1", input.readLine());
				channels.add(channel);
			 }
			 else{
				channelExists = false;
				break; 
			 }
		  } 
		  
		  if(channelExists) {
		  
		     System.err.println("There is " + channels.size() + " channel !");
		  
		     //We will get the 1st playlist to make things simple for this Demo
		     Channel channel = channels.get(0);
		  
		     if( listOfPlaylists(playlists) ) {
		     
		        System.err.println("Above is the list of available Play Lists.");
		        System.err.println("Enter the number on the left side of Play List name to add it to the Channel : ");
		  
		        int number_of_play_list = Integer.parseInt(input.readLine());
		  
		        PlayList playList = playlists.get(number_of_play_list - 1);
		    		 
		        channel.addPlaylistToChannel(playList);
		     
		        boolean playListExistsInChannel = true;
		     
		     
		        for(PlayList p : channel.getPlaylists()){
		    	   if(p.getId() == playList.getId()){
		    	      playListExistsInChannel = false;
		    	      System.err.println("Play List with that ID already exists in Channel !");
		    	   } 
		        }
		     
		        if(playListExistsInChannel){
		        
		           channel.addPlaylistToChannel(playList);
		        }
		     
		        //Sorting videos in Play List in ascending order
		        Collections.sort(channel.getPlaylists(), new Comparator<PlayList>(){
			       @Override
			       public int compare(PlayList lhs, PlayList rhs){
			          // -1 - less than, 1 - greater than, 0 - equal
			          return lhs.getOrderNumber() < rhs.getOrderNumber() ? -1 : (lhs.getOrderNumber() > rhs.getOrderNumber()) ? 1 : 0;
			       }
	            });
		     
		        }
		        else{
		    	   System.err.println("There are no available Play Lists to pick up from ! Please make any Play List 1st."); 
		        }
		  }
		  else{
			 System.err.println("Channel has not been created !");
		  }
	}
	
	public static void changeVideoOrder(BufferedReader input, List<PlayList> playlists) throws NumberFormatException, IOException {
	   System.err.println("Enter the Number of Video which you want to move : ");
	   
	   int oldOrderNumber = Integer.parseInt(input.readLine());
	   
       System.err.println("Enter the Number of Video on which space you want to move previous video : ");
	   
	   int newOrderNumber = Integer.parseInt(input.readLine());
	   
	   PlayList playList = playlists.get(0);
	   List<Video> videos = playList.getListOfVideos();
	   
	   Video movedVideo = videos.get(oldOrderNumber-1);
	   int movedVideoOrderNumber = movedVideo.getOrderNumber();
		  
	   Video newSpaceVideo = videos.get(newOrderNumber-1);
	   int newSpaceOrderNumber = newSpaceVideo.getOrderNumber();
	   
	   if(oldOrderNumber < newOrderNumber){ 	  
		  for(int i = movedVideoOrderNumber ; i <= newSpaceOrderNumber-1 ; i++){
			 videos.get(i).setOrderNumber(i); 
		  }
	   }
	   else{ 		  
		  for(int i = movedVideoOrderNumber-1 ; i >= newSpaceOrderNumber ; i--){
			 videos.get(i-1).setOrderNumber(i+1); 
		  }
	   }
	   
	   movedVideo.setOrderNumber(newSpaceOrderNumber);
	   
	   //Sorting videos in Play List in ascending order
	   Collections.sort(playList.getListOfVideos(), new Comparator<Video>(){
		  @Override
		  public int compare(Video lhs, Video rhs){
		     // -1 - less than, 1 - greater than, 0 - equal
		     return lhs.getOrderNumber() < rhs.getOrderNumber() ? -1 : (lhs.getOrderNumber() > rhs.getOrderNumber()) ? 1 : 0;
		  }
       });
		
	}	
   
	
   public static void deleteVideoFromPlaylist(BufferedReader input, List<PlayList> playlists) throws NumberFormatException, IOException{
	  System.err.println("Enter the Number of Video you want to delete from the Play List : ");
	  
	  int number = Integer.parseInt(input.readLine());
	  
	  PlayList playList = playlists.get(0);
	  List<Video> videos = playList.getListOfVideos();
	  
	  for(Video v: videos){
		 if(Integer.parseInt(v.getId()) == number){
			videos.remove(v); 
			
			System.err.println("Video with ID=" + v.getId() + " has been removed from the Play List !");
			
			if(videos.size() == 0) break;
		 } 
	  } 
   }	
	
   public static void printPlaylist(List<PlayList> playlists){
	  if(playlists.isEmpty()) {
		 System.out.println();
		 System.err.println("There is no existing Play List made yet. Please use option 2 for adding new videos first.");
		 System.out.println();
	  }
	  else {
	     PlayList playList = playlists.get(0);
	     List<Video> videos = playList.getListOfVideos();
	  
	     System.out.println("All the videos in the playlist ' " + playList.getName() + " ' :");
	     listOfVideos(videos);
	  }
   }	
   
   public static void makeListOfVideos(List<Video> videos){
	  for(int i=1; i <= 10; i++){
		 Video video = new Video(""+i, "Funny_"+i);
		 video.setOrderNumber(i);
		 videos.add(video);
	  } 
   }
   
   //ovde sam menjao iz v.getId() u v.getOrderNumber()
   public static void listOfVideos(List<Video> videos){
	  System.out.println("List of videos : {");
	  for(Video v : videos){
		 System.out.println("{" + v.getOrderNumber() + " " + v.getName() + "}");   
	  } 
	  System.out.println("}");
   }
   
   public static boolean listOfPlaylists(List<PlayList> playLists){
	  
	  boolean empty = true;
	  
	  if(playLists.isEmpty()) {
	     System.out.println("There are no playlists in System !");
	     empty = false;
	     return empty;
	  }
	  else{
	     System.out.println("List of Play Lists : {");
	     for(PlayList p : playLists){
		    System.out.println("{" + p.getOrderNumber() + " " + p.getName() + "}"); 
	     }
	     System.out.println("}");
	     return empty;
	  }
	  
   }
   
   public static void addVideoToPlayList(BufferedReader input, User user, List<PlayList> playlists, List<Video> videos) throws IOException{
	  
	  boolean playlistExists = true;
	  
	  while(playlists.isEmpty()){
		 System.err.println("There are no available playlists !"); 
		 System.err.println("Do you want to create one ? Y/N");
		 
		 String answer = input.readLine();
		 
		 if(answer.equalsIgnoreCase("Y")){
			System.err.println("Enter the name of the Playlist : ");
			PlayList playList = new PlayList("1", input.readLine(), user);
			playlists.add(playList);
		 }
		 else{
			playlistExists = false; 
			break; 
		 }
	  } 
	  
	  if(playlistExists) {
	  
	     System.err.println("There is " + playlists.size() + " playlist !");
	  
	     //We will get the 1st playlist to make things simple for this Demo
	     PlayList playlist = playlists.get(0);
	  
	     listOfVideos(videos);
	     System.err.println("Above is the list of available videos.");
	     System.err.println("Enter the number on the left side of video name to add it to the playlist : ");
	  
	     int number_of_video = Integer.parseInt(input.readLine());
	  
	     Video video = videos.get(number_of_video - 1);
	     
	     boolean videoExistsInPlayList = true;
	     
	     for(Video v : playlist.getListOfVideos()){
	    	if(v.getId() == video.getId()){
	    	   videoExistsInPlayList = false;	
	    	   System.err.println("Video with that ID already exists in Play List !");
	    	} 
	     }
	     
	     if(videoExistsInPlayList){
	    	 
	        playlist.addVideoToPlaylist(video);
	     }
	     
	     //Sorting videos in Play List in ascending order
	     Collections.sort(playlist.getListOfVideos(), new Comparator<Video>(){
		    @Override
		    public int compare(Video lhs, Video rhs){
		       // -1 - less than, 1 - greater than, 0 - equal
		       return lhs.getOrderNumber() < rhs.getOrderNumber() ? -1 : (lhs.getOrderNumber() > rhs.getOrderNumber()) ? 1 : 0;
		    }
         });
	  }
	  else{
		 System.err.println("Play List has not been created !");
	  }
   }
   
	
   public static void main(String [] args) throws IOException {
	  //List of Users in case that we need more then one User
	  List<User> users = new ArrayList<>(); 
	  
	  User user = new User("1","Misa");
	  users.add(user);
	  
	  //If one User wants to have more then 1 playlist
	  List<PlayList> playlists = new ArrayList<>();
	  
	  //User can create multiple Channels
	  List<Channel> channels = new ArrayList<>();
	  
	  //Making predefined list of 10 videos to choose from
	  List<Video> videos = new ArrayList<>();
	  makeListOfVideos(videos);
	  
	  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	  
	  String input;
	  
	  do{
		   System.out.println("****************** VIDEO PLAY LIST ********************");
		   System.out.println("Enter offered command number for executing next functions: ");
		   System.out.println("--------------------------------------------------");
		   System.out.println("1 --- Return sorted list of videos for Play List");
		   System.out.println("--------------------------------------------------");
		   System.out.println("2 --- Add video to Play List");
		   System.out.println("--------------------------------------------------");
		   System.out.println("3 --- Delete video from Play List");
		   System.out.println("--------------------------------------------------");
		   System.out.println("4 --- Change order number of video in Play List");
		   System.out.println("--------------------------------------------------");
		   System.out.println("5 --- Return sorted list of Play lists for Channel");
		   System.out.println("--------------------------------------------------");
		   System.out.println("x --- End Program Execution");
		   System.out.println("**************************************************"); 
		  
		   input = in.readLine(); 
		   
		   switch(input){
		      case "1":
		    	 //listOfVideos(videos);
		    	 printPlaylist(playlists);
		    	 break;
		      case "2":
		    	 addVideoToPlayList(in,user,playlists, videos);
		    	 break;
		      case "3":
		    	 deleteVideoFromPlaylist(in, playlists); 
		    	 break;
		      case "4":
		    	 changeVideoOrder(in,playlists);
		    	 break;
		      case "5":
		    	 addPlayListToChannel(in,playlists,channels);
		    	 break;
		   }
	  } while(!input.equals("x"));
	  
	  System.err.println("Program is shut down. Have a nice day.");
	  
   }
}
