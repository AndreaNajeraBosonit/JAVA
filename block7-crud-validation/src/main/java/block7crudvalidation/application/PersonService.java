package block7crudvalidation.application;

import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.controller.dto.PersonOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface PersonService {

    PersonOutputDto addPerson(PersonInputDto person) throws Exception;
    PersonOutputDto getPersonById(int id);

    List<PersonOutputDto> getAllPerson();
    List<PersonOutputDto> getPersonsByUsuario(String usuario);
    String deletePersonById (int id);



}
