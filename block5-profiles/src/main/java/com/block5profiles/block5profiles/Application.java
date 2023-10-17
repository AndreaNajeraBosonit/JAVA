package com.block5profiles.block5profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class Application implements CommandLineRunner {

	@Value("${activeProfile:NINGUNO}")
	private String activeProfile;

	@Value("${bd.url:sin url}")
	private String bdUrl;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Active Profile: " + activeProfile);
		System.out.println("Database URL: " + bdUrl);
	}
}
