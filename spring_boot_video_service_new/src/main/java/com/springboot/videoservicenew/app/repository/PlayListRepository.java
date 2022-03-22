package com.springboot.videoservicenew.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.videoservicenew.app.model.PlayListModel;

import java.util.List;

public interface PlayListRepository extends JpaRepository<PlayListModel, Long>{

    //add a method to sort by order_number
    public List<PlayListModel> findAllByOrderByOrderNumberAsc();
}
