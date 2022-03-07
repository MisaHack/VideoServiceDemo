package com.springboot.videoservicenew.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.springboot.videoservicenew.app.model.VideoModel;

@DataJpaTest
@Transactional
@ActiveProfiles("test")
public class VideoRepositoryEmbeddedTest {

   @Autowired
   private VideoRepository videoRepository;
   
   @Test
   public void shouldSaveUser(){
	  //given
	  VideoModel video = new VideoModel("Spiderman 1", 1);
	  
	  //when
	  VideoModel savedVideo = videoRepository.save(video);
	  
	  //then
	  //assertThat(savedVideo).usingRecursiveComparison().ignoringFields("video_id").isEqualTo(video);
	  assertThat(savedVideo).usingRecursiveComparison().isEqualTo(video);
   }
   
   @Test
   //@Sql("classpath: test-data.sql")
   //@Sql("{/test-data.sql}")
   @Sql("/test-data.sql")
   public void shouldSaveUserThroughSqlFile(){
	   
	  //given
	  Optional<VideoModel> test = videoRepository.findVideoByName("Titanic");
	  
	  //when
	  
	  //then
	  assertThat(test).isNotEmpty();
   }
   
}
