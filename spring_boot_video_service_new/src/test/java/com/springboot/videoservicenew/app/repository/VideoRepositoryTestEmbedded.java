package com.springboot.videoservicenew.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.springboot.videoservicenew.app.model.VideoModel;

@DataJpaTest
@ActiveProfiles("test")
public class VideoRepositoryTestEmbedded {

   @Autowired
   private VideoRepository videoRepository;
   
   @Test
   public void shouldSaveUser(){
	  //given
	  VideoModel video = new VideoModel(1, "Spiderman 1");
	  
	  //when
	  VideoModel savedVideo = videoRepository.save(video);
	  
	  //then
	  assertThat(savedVideo).usingRecursiveComparison().ignoringFields("video_id").isEqualTo(video);
   }
   
   @Test
   @Sql("classpath: test-data.sql")
   //@Sql("{/test-data.sql}")
   public void shouldSaveUserThroughSqlFile(){
	  Optional<VideoModel> test = videoRepository.findVideoByName("Titanic");
	  
	  assertThat(test).isNotEmpty();
   }
   
}
