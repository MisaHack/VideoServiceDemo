package com.springboot.videoservicenew.app.repository;

import com.springboot.videoservicenew.app.model.ChannelModel;
import com.springboot.videoservicenew.app.model.ChannelPlayListModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelPlayListRepository extends JpaRepository<ChannelPlayListModel, Long>{

    //add a method to sort by order_number
    public List<ChannelModel> findAllByOrderByOrderNumberAsc();
}
