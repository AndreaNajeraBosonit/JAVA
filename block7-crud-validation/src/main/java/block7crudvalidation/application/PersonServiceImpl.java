


package block7crudvalidation.application;


        import block7crudvalidation.controller.dto.PersonInputDto;
        import block7crudvalidation.controller.dto.PersonOutputDto;

public class PersonService {

    PersonOutputDto addPerson(PersonInputDto person);
    PersonOutputDto getPersonById(int id);
    void deletePersonById( int id);
    Iterable<PersonOutputDto> getAllPerson(int pageNumber, int pageSize);
    PersonOutputDto updatePerson(PersonInputDto person);
}
