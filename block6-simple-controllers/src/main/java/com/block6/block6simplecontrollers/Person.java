package com.block6.block6simplecontrollers;

import org.springframework.web.bind.annotation.*;

@RestController

public class Person {

        public String nombre;
        public String poblacion;
        public int edad;


    public String getNombre() {
        return nombre;
    }

    // Setter para establecer la edad
    public void setPoblacione(String poblacion) {
        this.poblacion = poblacion;
    }
    public String getpoblacion() {
        return poblacion;
    }

    // Setter para establecer la edad
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para obtener la edad
    public int getEdad() {
        return edad;
    }

    // Setter para establecer la edad
    public void setEdad(int edad) {
        this.edad = edad;
    }



        @GetMapping(value = "/user/{nombre}")
    public String hola(@PathVariable String nombre) {
        return "Hola  " + nombre;
    }
    @PostMapping("/useradd")
    public Person agregarUsuario(@RequestBody Person person) {
        // Incrementar la edad en 1
        person.setEdad(person.getEdad() + 1);
        return person;
    }
}