package com.block7crud1.block7crud1.controller;

import com.block7crud1.block7crud1.application.PersonServiceImpl;
import com.block7crud1.block7crud1.controller.dto.PersonInputDto;
import com.block7crud1.block7crud1.controller.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/person")
public class Controller {
    @Autowired
    PersonServiceImpl personService;
/*
    @PostMapping
    public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto person) {
        URI location = URI.create("/person");
        return ResponseEntity.created(location).body(personService.addPerson(person));
    }*/

  /*  @GetMapping("/{id}")
    public ResponseEntity<PersonOutputDto> getPersonById(@PathVariable int id) {
        try {
            return ResponseEntity.ok().body(personService.getPersonById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }*/
/*
    @DeleteMapping
    public ResponseEntity<String> deletePersonById(@RequestParam int id) {
        try {
            personService.deletePersonById(id);
            return ResponseEntity.ok().body("person with id: "+id+" was deleted");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

}
    }


    @GetMapping
    public Iterable<PersonOutputDto> getAllPersons(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "4", required = false) int pageSize) {

        return personService.getAllPersons(pageNumber, pageSize);
    }
/*
    @PutMapping
    public ResponseEntity<PersonOutputDto> updatePerson(@RequestBody PersonInputDto person) {
        try {
            personService.getPersonById(person.getId());
            return  ResponseEntity.ok().body(personService.addPerson(person));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }*/

}

