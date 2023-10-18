package com.block6personcontrollers.block6personcontrollers.service;

import com.block6personcontrollers.block6personcontrollers.model.PersonaModel;
import org.springframework.stereotype.Service;
    @Service
    public class PersonaService {

        PersonaModel personaModel;

        public PersonaModel createPersona(String nombre, String poblacion, int edad){
            personaModel = new PersonaModel(nombre, poblacion, edad);
            return personaModel;
        }


        public PersonaModel multiplicarEdadPorDos() {
            personaModel.setEdad(personaModel.getEdad() * 2);
            return personaModel;
        }
    }





