package block7crudvalidation.controller;

import block7crudvalidation.application.PersonServiceImpl;
import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.controller.dto.PersonOutputDto;
import block7crudvalidation.exceptions.UnprocessableEntityException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@RequestMapping("/person")
public class Controller {
    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonOutputDto> getPersonById(@PathVariable int id) {
        try {

            return ResponseEntity.ok().body(personService.getPersonById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto person) throws Exception {

        return ResponseEntity.ok().body(personService.addPerson(person));
    }



    @GetMapping
    public ResponseEntity<List<PersonOutputDto>> getAllPerson() {
        List<PersonOutputDto> person = personService.getAllPerson();

        return ResponseEntity.ok(person);

    }
    //http://localhost:8080/person/usuario?usuario=usuario
    @GetMapping("/usuario")
    public ResponseEntity<String> searchPersonsByName(@RequestParam("usuario") String usuario) {
        List<PersonOutputDto> person = personService.getPersonsByUsuario(usuario);
        if (person.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EntityNotFoundException("El usuario con nombre: " + usuario + " no existe").getMessage());
        }
        return ResponseEntity.ok(person.toString());
    }

    /*   @PostMapping
   public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto person) {
       URI location = URI.create("/person");
       return ResponseEntity.created(location).body(personService.addPerson(person));
   }*/


        @DeleteMapping
        public ResponseEntity<String> deletePersonById(@RequestParam int id) {
                return ResponseEntity.ok(personService.deletePersonById(id));

        }


    }

