package com.springboot.videoservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//(exclude = {DataSourceAutoConfiguration.class,
//		/*ovo sam dodao zbog bean greske, pa mi ne pokrene APP*/ JpaRepositoriesAutoConfiguration.class }
//)
public class SpringBootVideoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVideoServiceApplication.class, args);
	}
}
