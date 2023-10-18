package com.block6personcontrollers.block6personcontrollers.controller;

import com.block6personcontrollers.block6personcontrollers.model.CiudadModel;
import com.block6personcontrollers.block6personcontrollers.model.PersonaModel;
import com.block6personcontrollers.block6personcontrollers.service.CiudadService;
import com.block6personcontrollers.block6personcontrollers.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {
    private final PersonaService personaService;
    private final CiudadService ciudadService;

    //tercer ejercicio
    private final PersonaModel bean1;
    private final PersonaModel bean2;
    private final PersonaModel bean3;

    @Autowired
    public Controlador1(PersonaService personaService,
                        CiudadService ciudadService,
                        @Qualifier("bean1") PersonaModel bean1,
                        @Qualifier("bean2") PersonaModel bean2,
                        @Qualifier("bean3") PersonaModel bean3) {
        this.personaService = personaService;
        this.ciudadService = ciudadService;
        this.bean1 = bean1;
        this.bean2 = bean2;
        this.bean3 = bean3;
    }

    @GetMapping("/getPersonas")
    public ResponseEntity<PersonaModel> verPersonas(
            @RequestBody PersonaModel personaModel) {
        PersonaModel persona = personaService.createPersona(personaModel.getNombre(),
                personaModel.getPoblacion(), personaModel.getEdad());
        return ResponseEntity.ok(persona);
    }

    @GetMapping("/addPersona")
    public ResponseEntity<PersonaModel> agregarPersona(
            @RequestBody PersonaModel personaModel) {
        PersonaModel persona = personaService.createPersona(personaModel.getNombre(),
                personaModel.getPoblacion(), personaModel.getEdad());
        return ResponseEntity.ok(persona);
    }


    @PostMapping("/addCiudad")
    public ResponseEntity<CiudadModel> agregarCiudad(
            @RequestBody CiudadModel ciudadModel) {
        CiudadModel ciudad = ciudadService.createCiudad(ciudadModel.getNombre(),
                ciudadModel.getNumeroHabitantes());
        return ResponseEntity.ok(ciudad);

    }

    @GetMapping("/bean/{bean}")
    public PersonaModel obtenerBean(@PathVariable String bean) {
        switch (bean) {
            case "bean1":
                return bean1;
            case "bean2":
                return bean2;
            case "bean3":
                return bean3;
            default:
                // Manejar el caso cuando el parámetro no coincide con ningún bean
                return null;
        }
    }
}



