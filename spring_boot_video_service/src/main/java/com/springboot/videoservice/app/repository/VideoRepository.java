package com.springboot.videoservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservice.app.model.Video;

public interface VideoRepository extends JpaRepository<Video, String> {

}
