package com.springboot.mysqlconnection.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MySqlConnectionApplication implements CommandLineRunner{

	//allows us to connect to database through jdbc
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(MySqlConnectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO users (fullname, email, password) VALUES (?,?,?)";
		int result = JdbcTemplate.update(sql, "Misa Lihvarcek","lihvarcekmisa@yahoo.com","123");
		
		if(result > 0) {
		   System.out.println("A new row has been inserted.");	
		}
	}

}
