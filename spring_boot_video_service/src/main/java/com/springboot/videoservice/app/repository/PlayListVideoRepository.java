package com.springboot.videoservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservice.app.model.PlayListVideoModel;

public interface PlayListVideoRepository extends JpaRepository<PlayListVideoModel, Long> {
   
}
