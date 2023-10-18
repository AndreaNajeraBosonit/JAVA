package com.block6personcontrollers.block6personcontrollers.service;

import com.block6personcontrollers.block6personcontrollers.model.CiudadModel;
import com.block6personcontrollers.block6personcontrollers.model.PersonaModel;
import org.springframework.stereotype.Service;


    @Service
    public class CiudadService {

        CiudadModel  ciudadModel;

        public CiudadModel createCiudad(String nombre, int numerohabitantes){
            ciudadModel = new CiudadModel(nombre, numerohabitantes);
            return ciudadModel;
        }



    }

