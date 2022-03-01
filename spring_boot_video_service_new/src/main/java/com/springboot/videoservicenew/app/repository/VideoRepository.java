package com.springboot.videoservicenew.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservicenew.app.model.VideoModel;

public interface VideoRepository extends JpaRepository<VideoModel, Long> {

}
