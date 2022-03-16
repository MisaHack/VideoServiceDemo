package com.springboot.videoservicenew.app.service;

import com.springboot.videoservicenew.app.model.PlayListModel;
import com.springboot.videoservicenew.app.repository.CategoryRepository;
import com.springboot.videoservicenew.app.repository.PlayListRepository;
import com.springboot.videoservicenew.app.repository.VideoRepository;
import com.springboot.videoservicenew.app.service.impl.PlayListServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//Using Mockito to mock dependencies of PlayListServiceImpl

public class PlayListServiceUnitTest
{
    //PlayListService class with implemented methods
    private PlayListServiceImpl playListService;

    //we instantiate new variables that will hold mocked objects
    private PlayListRepository playListRepositoryMock;
    private CategoryRepository categoryRepositoryMock;
    private VideoRepository videoRepositoryMock;

    @BeforeEach
    void setup(){
        //mock - is the method of Mockito that creates dummy class
        //it has same methods as real class, so behaves same
       this.playListRepositoryMock = mock(PlayListRepository.class);
       this.categoryRepositoryMock = mock(CategoryRepository.class);
       this.videoRepositoryMock = mock(VideoRepository.class);

       this.playListService = new PlayListServiceImpl(playListRepositoryMock , categoryRepositoryMock , videoRepositoryMock);

       //checking return value of save() method in playListRepositoryMock
       System.out.println("Play Lists returned : " + playListRepositoryMock.save(new PlayListModel("RockMusic",1)));
    }

    @Test
    void shouldReturnSavedPlayList(){
        //given
        PlayListModel playListModel = new PlayListModel("RockMusic",1);

        //when method save() inside playListRepositoryMock is called we add
        //functionality to it for returning new PlayListModel
        when(this.playListRepositoryMock.save(playListModel)).thenReturn(new PlayListModel("RockMusic",1));

        PlayListModel expectedPlayList = new PlayListModel("RockMusic",1);

        //when
        PlayListModel actualModel = playListService.savePlayList(playListModel);

        //then
        assertNotNull(actualModel);
        assertEquals("RockMusic",actualModel.getName());
        assertEquals(1, actualModel.getOrderNumber());
        assertEquals(actualModel, expectedPlayList);
        //assertTrue(expectedPlayList.equals(actualModel));
        //verify(playListRepositoryMock, times(1)).save(playListModel);
    }

    void shouldReturnAllPlayLists(){
        //given
        PlayListModel playListModel1 = new PlayListModel("RockMusic",1);
        PlayListModel playListModel2 = new PlayListModel("TechnoMusic",2);
        PlayListModel playListModel3 = new PlayListModel("CoolMusic",3);

        //when


        //then
    }
}
