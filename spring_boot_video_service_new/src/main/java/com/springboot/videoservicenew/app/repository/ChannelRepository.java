package com.springboot.videoservicenew.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservicenew.app.model.ChannelModel;

public interface ChannelRepository extends JpaRepository<ChannelModel, Long>{

}
