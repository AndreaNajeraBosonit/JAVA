package block7crudvalidation.controller;

import block7crudvalidation.application.PersonService;
import block7crudvalidation.application.PersonServiceImpl;
import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.controller.dto.PersonOutputDto;
import block7crudvalidation.controller.dto.StudentOutputDto;
import block7crudvalidation.exceptions.UnprocessableEntityException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    PersonService personService;

    @GetMapping("/{idPerson}")
    public ResponseEntity<PersonOutputDto> getPersonById(@PathVariable Long idPerson) {
        try {

            return ResponseEntity.ok().body(personService.getPersonById(idPerson));
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

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonResponse = objectMapper.writeValueAsString(person);
            return ResponseEntity.ok(jsonResponse);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la respuesta JSON");
        }

    }

    /*   @PostMapping
   public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto person) {
       URI location = URI.create("/person");
       return ResponseEntity.created(location).body(personService.addPerson(person));
   }*/



    @DeleteMapping("/{idPerson}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long idPerson) {
        String message = personService.deletePersonById(idPerson);
        return ResponseEntity.ok(message);
   }


    }

