package com.springboot.videoservicenew.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservicenew.app.model.PlayListModel;

public interface PlayListRepository extends JpaRepository<PlayListModel, Long>{

}
