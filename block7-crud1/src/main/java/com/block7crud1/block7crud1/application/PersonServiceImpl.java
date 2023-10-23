package com.block7crud1.block7crud1.application;

import com.block7crud1.block7crud1.controller.dto.PersonInputDto;
import com.block7crud1.block7crud1.controller.dto.PersonOutputDto;
import com.block7crud1.block7crud1.domain.Person;
import com.block7crud1.block7crud1.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

    public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Override
    public PersonOutputDto addPerson(PersonInputDto person ){
        return personRepository.save(new Person(person))
                .personToPersonOutputDto();
    }
    @Override
    public PersonOutputDto getPersonById(int id){
        return personRepository.findById(id).orElseThrow()
                .personToPersonOutputDto();
    }

    @Override
    public void deletePersonById(int id) {
        personRepository.findById(id).orElseThrow();
        personRepository.deleteById(id);
    }
  /*  @Override
    public List<PersonOutputDto> getAllPersons(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return personRepository.findAll(pageRequest).getContent()
                .stream()
                .map(Person::personToPersonOutputDto).toList();
    }*/
    @Override
    public PersonOutputDto updatePerson(PersonInputDto person) {
        personRepository.findById(person.getId()).orElseThrow();
        return personRepository.save(new Person(person))
                .personToPersonOutputDto();
    }

    @Override
    public List<PersonOutputDto> getAllPersons() {
        List<Person> person = personRepository.findAll();
        return person.stream()
                .map(Person::personToPersonOutputDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<PersonOutputDto> getPersonsByNombre(String nombre) {
        List<Person> person = personRepository.findByNombreContainingIgnoreCase(nombre);
        return person.stream()
                .map(Person::personToPersonOutputDto)
                .collect(Collectors.toList());
    }

}
