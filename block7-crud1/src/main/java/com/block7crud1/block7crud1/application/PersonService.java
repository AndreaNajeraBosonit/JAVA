package com.block7crud1.block7crud1.application;

import com.block7crud1.block7crud1.controller.dto.PersonInputDto;
import com.block7crud1.block7crud1.controller.dto.PersonOutputDto;
import com.block7crud1.block7crud1.domain.Person;

import java.util.List;

public interface PersonService {

    PersonOutputDto addPerson(PersonInputDto person);
    PersonOutputDto getPersonById(int id);
    void deletePersonById( int id);
    PersonOutputDto updatePerson(PersonInputDto person);
    List<PersonOutputDto> getAllPersons();
    List<PersonOutputDto> getPersonsByNombre(String nombre);

}
