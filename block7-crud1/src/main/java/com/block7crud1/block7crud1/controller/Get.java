package com.block7crud1.block7crud1.controller;

import com.block7crud1.block7crud1.application.PersonServiceImpl;
import com.block7crud1.block7crud1.controller.dto.PersonOutputDto;
import com.block7crud1.block7crud1.domain.Person;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persona")
public class Get {
    @Autowired
    PersonServiceImpl personService;


    //La peticion Postman es http://localhost:8080/persona/"id"
    @GetMapping("/{id}")
    public ResponseEntity<PersonOutputDto> getPersonById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personService.getPersonById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Devolver Lista de personas
    //Peticion de postMan http://localhost:8080/persona
   @GetMapping
    public ResponseEntity<List<PersonOutputDto>> getAllPersons() {
        List<PersonOutputDto> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);

    }
    //Por nombre prueba
    //http://localhost:8080/persona/nombre?nombre="NOMBRE"
    @GetMapping("/nombre")
    public ResponseEntity<List<PersonOutputDto>> searchPersonsByName(@RequestParam("nombre") String nombre) {
        List<PersonOutputDto> person = personService.getPersonsByNombre(nombre);
        return ResponseEntity.ok(person);
    }




/*
    //La peticion Postman es http://localhost:8080/persona para ver todas las personas
    @GetMapping
    public Iterable<PersonOutputDto> getAllPersons(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize) {

        return personService.getAllPersons(pageNumber, pageSize);
    }*/

}