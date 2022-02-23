package com.springboot.videoservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservice.app.model.Channel;

public interface ChannelRepository extends JpaRepository<Channel, String>{

}
