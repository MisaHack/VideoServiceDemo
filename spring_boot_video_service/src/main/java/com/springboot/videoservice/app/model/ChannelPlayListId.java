package com.springboot.videoservice.app.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ChannelPlayListId implements Serializable {
	private long ChannelId;
	private long PlayListId;

	public long getChannelId() {
		return ChannelId;
	}

	public void setChannelId(long channelId) {
		ChannelId = channelId;
	}

	public long getPlayListId() {
		return PlayListId;
	}

	public void setPlayListId(long playListId) {
		PlayListId = playListId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ChannelId, PlayListId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChannelPlayListId other = (ChannelPlayListId) obj;
		return ChannelId == other.ChannelId && PlayListId == other.PlayListId;
	}

	
	
}
