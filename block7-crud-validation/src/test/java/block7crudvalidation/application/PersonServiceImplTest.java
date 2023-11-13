package block7crudvalidation.application;
import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.controller.dto.PersonOutputDto;
import block7crudvalidation.domain.Person;
import block7crudvalidation.exceptions.CustomError;
import block7crudvalidation.exceptions.UnprocessableEntityException;
import block7crudvalidation.repository.PersonRepository;
import block7crudvalidation.repository.ProfesorRepository;
import block7crudvalidation.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

import java.util.*;
import java.util.stream.Collectors;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {
    @Mock
    private PersonRepository personRepository;

    @Mock
    private ProfesorRepository profesorRepository;

    @Mock
    private StudentRepository studentRepository;


    @Mock
    private CustomError customError;
    @InjectMocks
    private PersonServiceImpl personService;



    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPersonInvalidEmail() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setUsuario("testuser");
        personInputDto.setPersonal_email("invalidemail");

        // Verificar que se lance la excepción UnprocessableEntityException
        assertThrows(UnprocessableEntityException.class, () -> {
            personService.addPerson(personInputDto);
        });
    }
    @Test
    public void testAddPerson_NullUsuario() {
        // Arrange
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setUsuario(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            personService.addPerson(personInputDto);
        });
    }
    @Test
    public void testAddPerson_LongUsuario() {
        // Arrange
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setUsuario("usuarioDemasiadoLargo"); // más de 10 caracteres

        // Act & Assert
        assertThrows(Exception.class, () -> {
            personService.addPerson(personInputDto);
        });
    }
    @Test
    public void testAddPerson_LongEmail() {
        // Arrange
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setPersonal_email("correo@dominio.com".repeat(4)); // más de 30 caracteres

        // Act & Assert
        assertThrows(Exception.class, () -> {
            personService.addPerson(personInputDto);
        });
    }
    @Test
    public void testDeletePersonById() {
        // Configurar el comportamiento del repositorio para devolver una persona existente
        when(personRepository.findById(1L)).thenReturn(Optional.of(new Person()));

        // Llamar al método para eliminar la persona
        String result = personService.deletePersonById(1L);

        // Verificar que se llamen los métodos correspondientes de los repositorios
        verify(personRepository, times(1)).deleteById(1L);
        // Verificar el resultado del método
        assertEquals("La persona con ID 1 y sus asociaciones con Estudiante y Profesor han sido eliminadas correctamente.", result);
    }


    @Test
    public void testGetAllPerson() {
        // Arrange
        Person person1 = new Person();
        Person person2 = new Person();
        List<Person> personList = Arrays.asList(person1, person2);

        when(personRepository.findAll()).thenReturn(personList);

        // Act
        List<PersonOutputDto> result = personService.getAllPerson();

        // Assert
        // Assuming you have a method to convert Person to PersonOutputDto
        assertEquals(2, result.size()); // Assuming there are 2 persons in the list
    }


    @Test
    public void getPersonsNameTest() {
        // Arrange
        String usuario = "nonExistentUser";

        // Mocking the repository method to return an empty list
        when(personRepository.findByUsuarioContainingIgnoreCase(usuario)).thenReturn(Arrays.asList());

        // Act
        List<PersonOutputDto> result = personService.getPersonsByUsuario(usuario);

        // Assert
        assertEquals(0, result.size());
    }
    @Test
    public void testGetPersonsByUsuarioWithNullInput() {
        // Arrange
        String usuario = null;

        // Act
        personService.getPersonsByUsuario(usuario);

        // Assert
        // Expects an IllegalArgumentException to be thrown when usuario is null
    }

    @Test
    public void testGetPersonById_ExistingPerson() {
        // Arrange
        Long idPerson = 1L;
        Person person = new Person(/* Initialize the person with necessary data */);
        when(personRepository.findById(idPerson)).thenReturn(Optional.of(person));

        // Act
        PersonOutputDto expectedOutputDto = person.personToPersonOutputDto();
        PersonOutputDto actualOutputDto = personService.getPersonById(idPerson);

        // Assert
        assertEquals(expectedOutputDto.getIdPerson(), actualOutputDto.getIdPerson());
        assertEquals(expectedOutputDto.getName(), actualOutputDto.getName());
        // ... continuar con otros campos
    }

    @Test
    public void testGetPersonById_NonExistingPerson() {
        // Arrange
        Long idPerson = 1L;
        when(personRepository.findById(idPerson)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            personService.getPersonById(idPerson);
        });
    }

}

