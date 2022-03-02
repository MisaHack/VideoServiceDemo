package com.springboot.videoservicenew.app.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class PlayListVideoModelKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "play_list_id")
	private long playListId;
	
	@Column(name = "video_id")
	private long videoId;

	@Override
	public int hashCode() {
		return Objects.hash(playListId, videoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayListVideoModelKey other = (PlayListVideoModelKey) obj;
		return playListId == other.playListId && videoId == other.videoId;
	}

	
}
