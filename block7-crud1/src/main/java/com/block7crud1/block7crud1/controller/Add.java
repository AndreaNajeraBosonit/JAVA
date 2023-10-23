package com.block7crud1.block7crud1.controller;

import com.block7crud1.block7crud1.application.PersonServiceImpl;
import com.block7crud1.block7crud1.controller.dto.PersonInputDto;
import com.block7crud1.block7crud1.controller.dto.PersonOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
@RestController
@RequestMapping("/persona")
//La peticion postman eshttp://localhost:8080/persona
public class Add {
    @Autowired
    PersonServiceImpl personService;

    @PostMapping
    public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto person) {
        URI location = URI.create("/person");
        return ResponseEntity.created(location).body(personService.addPerson(person));
    }
}
