package com.springboot.videoservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservice.app.model.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList, String>{

}
