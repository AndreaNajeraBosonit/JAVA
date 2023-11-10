package block7crudvalidation.application;

import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.controller.dto.PersonOutputDto;
import block7crudvalidation.controller.dto.ProfesorOutputDto;
import block7crudvalidation.domain.Person;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PersonService {

    PersonOutputDto addPerson(PersonInputDto person) throws Exception;
    PersonOutputDto getPersonById(Long idPerson);

    List<PersonOutputDto> getAllPerson();
    List<PersonOutputDto> getPersonsByUsuario(String usuario);
    String deletePersonById (Long idPerson);

    Page<PersonOutputDto> buscarPersonas(String usuario, String name, String surname,
                                         Date created_date, Date termination_date, int pageSize, int pageNumber);
}
