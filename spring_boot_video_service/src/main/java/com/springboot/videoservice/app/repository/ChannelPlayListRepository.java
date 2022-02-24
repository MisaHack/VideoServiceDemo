package com.springboot.videoservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservice.app.model.ChannelPlayListModel;

public interface ChannelPlayListRepository extends JpaRepository<ChannelPlayListModel, Long>{

}
