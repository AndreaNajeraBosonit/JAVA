package com.block6personcontrollers.block6personcontrollers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = "com.block6personcontrollers.block6personcontrollers")
public class Block6PersonControllersApplication {

	public static void main(String[] args) {
		SpringApplication.run(Block6PersonControllersApplication.class, args);
	}

}
