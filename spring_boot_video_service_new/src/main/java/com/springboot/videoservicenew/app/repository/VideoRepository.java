package com.springboot.videoservicenew.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.videoservicenew.app.model.VideoModel;

public interface VideoRepository extends JpaRepository<VideoModel, Long> {
   @Query("select name from VideoModel where name= :name")
   Optional<VideoModel> findVideoByName(@Param("name") String video_name);
}
