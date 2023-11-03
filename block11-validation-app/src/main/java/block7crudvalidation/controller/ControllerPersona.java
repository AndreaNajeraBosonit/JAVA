package block7crudvalidation.controller;

import block7crudvalidation.Feign.ProfesorFeignClient;
import block7crudvalidation.application.PersonService;
import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.controller.dto.PersonOutputDto;
import block7crudvalidation.controller.dto.ProfesorOutputDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RestController
@RequestMapping("/person")
public class ControllerPersona {

    @Autowired
    PersonService personService;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProfesorFeignClient profesorFeignClient;

//    public Controller(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }



    @GetMapping("/{idPerson}")
    public ResponseEntity<PersonOutputDto> getPersonById(@PathVariable Long idPerson) {
        try {

            return ResponseEntity.ok().body(personService.getPersonById(idPerson));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/addPerson")
    public ResponseEntity<PersonOutputDto> addPerson(@RequestBody PersonInputDto person) throws Exception {

        return ResponseEntity.ok().body(personService.addPerson(person));
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getAll")
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


  // USANDO RESTTEMPLATE  se utiliza por si hay dos apis y quieres juntar las dos en una misma consulta en un nuevo localhost
   @GetMapping("/profesorRT/{id}")
  public ProfesorOutputDto getProfesor(@PathVariable int id) {
        ResponseEntity<ProfesorOutputDto> respuesta= restTemplate.getForEntity("http://localhost:8081/profesor/"+id, ProfesorOutputDto.class);
        ProfesorOutputDto profesorOutputDto= respuesta.getBody();
       return profesorOutputDto;
//        // Llama al servicio del profesor en el puerto 8081 usando RestTemplate
////        String profesorServiceUrl = "http://localhost:8081/profesor/" + id;
////        return restTemplate.getForObject(profesorServiceUrl, ProfesorOutputDto.class);
    }

    //Feign
    @GetMapping("/profesor/{idProfesor}")
    public   ProfesorOutputDto getProfesor(@PathVariable("idProfesor") Long idProfesor){
        return profesorFeignClient.getProfesor(idProfesor);
    }




    }



