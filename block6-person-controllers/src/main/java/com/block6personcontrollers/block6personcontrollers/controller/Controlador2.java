package com.block6personcontrollers.block6personcontrollers.controller;

import com.block6personcontrollers.block6personcontrollers.model.CiudadModel;
import com.block6personcontrollers.block6personcontrollers.model.PersonaModel;
import com.block6personcontrollers.block6personcontrollers.service.CiudadService;
import com.block6personcontrollers.block6personcontrollers.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/controlador2")
public class Controlador2 {
    private final PersonaService personaService;
    private CiudadService ciudadService;

    @Autowired
    public Controlador2(PersonaService personaService, CiudadService ciudadService) {
        this.personaService = personaService;
        this.ciudadService = ciudadService;
    }

    @PostMapping("/getPersona")
    public ResponseEntity<PersonaModel> obtenerPersona() {
        PersonaModel personaModel = this.personaService.multiplicarEdadPorDos();
        return ResponseEntity.ok(personaModel);
    }
    @GetMapping("/getCiudades")
    public ResponseEntity<CiudadModel> verCiudades(
            @RequestBody CiudadModel ciudadModel) {
        CiudadModel ciudad = ciudadService.createCiudad(ciudadModel.getNombre(),
                ciudadModel.getNumeroHabitantes());
        return ResponseEntity.ok(ciudad);
    }
}

