package com.Maven.block13mongodb.Maven.block13mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = "com.Maven.block13mongodb")
public class MavenBlock13MongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenBlock13MongodbApplication.class, args);
	}

}
