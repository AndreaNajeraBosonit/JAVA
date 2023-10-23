package com.block7crud1.block7crud1.controller;

import com.block7crud1.block7crud1.application.PersonServiceImpl;
import com.block7crud1.block7crud1.controller.dto.PersonInputDto;
import com.block7crud1.block7crud1.controller.dto.PersonOutputDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/persona")
public class Put {
    @Autowired
PersonServiceImpl personService;
    //La peticion es http://localhost:8080/persona y en json se añade el Id que quieres cambiar

    @PutMapping
    public ResponseEntity<PersonOutputDto> updatePerson(@RequestBody PersonInputDto person) {
        try {
            personService.getPersonById(person.getId());
            return ResponseEntity.ok().body(personService.updatePerson(person));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
