package org.example;

import java.nio.file.Path;

public class Person
{
    String nombre;
    String edad;
    String ciudad;



    public Person(String nombre,  String ciudad,String edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return Integer.parseInt(edad);
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    @Override
    public String toString()
    {
        return "Nombre: "+nombre+ " Ciudad: "+ciudad+ " Edad: "+edad;

    }



}
