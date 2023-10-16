package com.block5.properties.block5.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	@Value("${greeting}")
	private String greeting;

	@Value("${my.number}")
	private int myNumber;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		Application app = context.getBean(Application.class);
		app.printValues();
	}

	private void printValues() {
		System.out.println("El valor de greeting es: " + greeting);
		System.out.println("El valor de my.number es: " + myNumber);
		String newProperty = System.getProperty("new.property", "new.property no tiene valor");
		System.out.println("El valor de new.property es: " + newProperty);
		String newValue = "valor de new.property";
		System.setProperty("new.property", newValue);
	}

}