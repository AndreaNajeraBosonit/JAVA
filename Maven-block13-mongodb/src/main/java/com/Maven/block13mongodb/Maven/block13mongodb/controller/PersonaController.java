package com.Maven.block13mongodb.Maven.block13mongodb.controller;

import com.Maven.block13mongodb.Maven.block13mongodb.domain.Persona;
import com.Maven.block13mongodb.Maven.block13mongodb.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonService personService;

    public PersonaController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Persona guardarPersona(@RequestBody Persona persona) {
        return personService.guardarPersona(persona);
    }

    @GetMapping
    public Page<Persona> obtenerPersonas(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamañoPagina) {
        return personService.obtenerPersonas(pagina, tamañoPagina);
    }

    @GetMapping("/{id}")
    public Persona obtenerPersonaPorId(@PathVariable Long id) {
        return personService.obtenerPersonaPorId(id);
    }

    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable Long id, @RequestBody Persona persona) {
        return personService.actualizarPersona(id, persona);
    }

    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personService.eliminarPersona(id);
    }
}
