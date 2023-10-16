package com.block5.properties.block5.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application  implements CommandLineRunner {
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

	/*3) Buscar la manera de leer la variable de entorno del Sistema Operativo “MYURL” mostrarla al arrancar el programa (con un CommandLineRunner).*/
	@Override
	public void run(String... args) throws Exception {
		String myUrl = System.getenv("MYURL");
		System.out.println("El valor de MYURL es: " + myUrl);

		/*3)Mostrar la variable MYURL2 que por defecto tenga un valor igual a “NO_tengo_valor” pero que si existe en el S.O. muestre lo que haya en el S.O.*/

		String myurl2 = System.getenv("MYURL2") != null ? System.getenv("MYURL2") : "no_tengo_valor";
		System.out.println("El valor de MYURL2 es: " + myurl2);
	}


}