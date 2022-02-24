package com.springboot.videoservice.app.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class PlayListVideoId implements Serializable{
	private long PlayListId;
	private long VideoId;

	public long getPlayListId() {
		return PlayListId;
	}

	public void setPlayListId(long playListId) {
		PlayListId = playListId;
	}

	public long getVideoId() {
		return VideoId;
	}

	public void setVideoId(long videoId) {
		VideoId = videoId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(PlayListId, VideoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayListVideoId other = (PlayListVideoId) obj;
		return PlayListId == other.PlayListId && VideoId == other.VideoId;
	}

	
}
