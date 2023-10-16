package com.block5.block5commandlinerunner;

import org.springframework.boot.CommandLineRunner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Block5 implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Block5.class, args);
    }

    @PostConstruct
    public String firstFunction() {
        return "Hola desde clase inicial  ";
    }

    @Override
    public void run(String... args) throws Exception {
        secondFunction();
        thirdFunction(secondFunction(), firstFunction());
    }

    public String secondFunction() {
        return "Hola desde clase secundaria  ";
    }

    public void thirdFunction(String param , String parametro) {
        System.out.println("Soy la tercera clase  " + param + parametro);
    }
}
/*
@SpringBootApplication

public class Block5 implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Block5.class, args);
    }

    @PostConstruct
    public void firstFunction() {
        System.out.println("Hola desde clase inicial");
    }

    @Override
    public void run(String... args) throws Exception {
        secondFunction();
        thirdFunction();
    }

    public void secondFunction() {
        System.out.println("Hola desde clase secundaria");
    }

    public void thirdFunction() {
        System.out.println("Soy la tercera clase");
    }
}
*/
