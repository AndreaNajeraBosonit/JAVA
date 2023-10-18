package com.block6personcontrollers.block6personcontrollers.model;

import org.springframework.context.annotation.Bean;

public class PersonaModel {

    public String nombre;
    public String poblacion;
    public int edad;


    public PersonaModel(String nombre, String poblacion, int edad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
    }

    public PersonaModel() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }



}
