package com.springboot.videoservicenew.app.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ChannelPlayListModelKey implements Serializable{
	
	@Column(name = "channel_id")
	private long channelId;
	
	@Column(name = "play_list_id")
	private long playListId;

	public long getChannelId() {
		return channelId;
	}
	
	//dodao sam konstruktore naknadno, trebaju nam
	public ChannelPlayListModelKey(){
	
	}
	
	public ChannelPlayListModelKey(long channelId, long playListId){
	   this.channelId = channelId;
	   this.playListId = playListId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(channelId, playListId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChannelPlayListModelKey other = (ChannelPlayListModelKey) obj;
		return channelId == other.channelId && playListId == other.playListId;
	}

	
	
}
