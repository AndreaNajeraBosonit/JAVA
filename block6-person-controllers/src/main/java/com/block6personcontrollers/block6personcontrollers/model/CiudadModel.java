package com.block6personcontrollers.block6personcontrollers.model;

public class CiudadModel {

        public String nombre;

        public int numeroHabitantes;


        public CiudadModel(String nombre, int numeroHabitantes) {
            this.nombre = nombre;

            this.numeroHabitantes = numeroHabitantes;
        }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroHabitantes(int numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }
}
