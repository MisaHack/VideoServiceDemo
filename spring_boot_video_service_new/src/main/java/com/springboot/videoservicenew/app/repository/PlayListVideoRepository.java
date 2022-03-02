package com.springboot.videoservicenew.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservicenew.app.model.PlayListVideoModel;

public interface PlayListVideoRepository extends JpaRepository<PlayListVideoModel, Long> {
   
}
