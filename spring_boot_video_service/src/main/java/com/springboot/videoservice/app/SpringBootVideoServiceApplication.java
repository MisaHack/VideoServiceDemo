package com.springboot.videoservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringBootVideoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVideoServiceApplication.class, args);
	}
}
