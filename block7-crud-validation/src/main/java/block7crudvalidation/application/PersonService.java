package block7crudvalidation.application;

import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.controller.dto.PersonOutputDto;
import block7crudvalidation.controller.dto.ProfesorOutputDto;

import java.util.List;

public interface PersonService {

    PersonOutputDto addPerson(PersonInputDto person) throws Exception;
    PersonOutputDto getPersonById(Long idPerson);

    List<PersonOutputDto> getAllPerson();
    List<PersonOutputDto> getPersonsByUsuario(String usuario);
    String deletePersonById (Long idPerson);

}
