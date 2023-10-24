


package block7crudvalidation.application;
import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.controller.dto.PersonOutputDto;
import block7crudvalidation.domain.Person;
import block7crudvalidation.exceptions.CustomError;
import block7crudvalidation.exceptions.EntityNotFoundException;
import block7crudvalidation.exceptions.UnprocessableEntityException;
import block7crudvalidation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.UncheckedIOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl  implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override

    public PersonOutputDto addPerson(PersonInputDto person) throws Exception {
            if (person.getUsuario() == null) {
                throw new IllegalArgumentException("Usuario no puede se nulo ");
            }
            if (person.getUsuario().length() > 10) {
                throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");
            }
            if (person.getPersonal_email().length() > 30) {
                throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");
            }
            // Validar el correo electrónico utilizando una expresión regular
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(person.getPersonal_email());
            //Hemos crreado la excepcion
            if (!matcher.matches()) {
                throw new UnprocessableEntityException("Correo electrónico no válido");
            }



            return personRepository.save(new Person(person))
                    .personToPersonOutputDto();

    }



    @Override
    public PersonOutputDto getPersonById(int id) {
        return personRepository.findById(id).orElseThrow()
                .personToPersonOutputDto();
    }


    @Override
    public List<PersonOutputDto> getAllPerson() {
        List<Person> person = personRepository.findAll();
        return person.stream()
                .map(Person::personToPersonOutputDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonOutputDto> getPersonsByUsuario(String usuario) {
        List<Person> person = personRepository.findByUsuarioContainingIgnoreCase(usuario);
        return person.stream()
                .map(Person::personToPersonOutputDto)
                .collect(Collectors.toList());
    }

    @Override
    public String deletePersonById(int id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty()) {
            throw new EntityNotFoundException("El usuario no ha sido encontrado");
        }
        personRepository.delete(person.get());
        return "El usuario con id: " + id + " ha sido borrado";


    }

}