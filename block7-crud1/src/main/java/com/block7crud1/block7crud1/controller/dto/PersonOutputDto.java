package com.block7crud1.block7crud1.controller.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PersonOutputDto {

        int id;
        String nombre;
        String edad;
        String poblacion;

    public PersonOutputDto(int id, String nombre, String edad, String poblacion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.poblacion = poblacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
}


