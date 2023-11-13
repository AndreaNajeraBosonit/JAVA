package block7crudvalidation.application;


import block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.controller.dto.ProfesorOutputDto;
import block7crudvalidation.domain.Person;
import block7crudvalidation.domain.Profesor;
import block7crudvalidation.domain.Student;
import block7crudvalidation.exceptions.UnprocessableEntityException;
import block7crudvalidation.repository.PersonRepository;
import block7crudvalidation.repository.ProfesorRepository;
import block7crudvalidation.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProfesorServiceImplTest {

    @Mock
    private ProfesorRepository profesorRepository;
    @Mock
    private PersonRepository personRepository;

    @Mock
    private StudentRepository studentRepository;


    @InjectMocks
    private ProfesorServiceImpl profesorService;
    private Profesor profesor;
    private Student student;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProfesorById() {
        // Datos de ejemplo
        Long idProfesor = 1L;
        Person person = new Person();
        Profesor profesor = new Profesor(1L, person);

        // Configuración del comportamiento simulado del repositorio
        when(profesorRepository.findById(idProfesor)).thenReturn(Optional.of(profesor));

        // Llamada al método que estamos probando
        ProfesorOutputDto result = profesorService.getProfesorById(idProfesor);

        // Verificación de que el método del repositorio fue llamado
        verify(profesorRepository, times(1)).findById(idProfesor);

        // Verificación del resultado de la llamada al método
        assertNotNull(result);
        assertEquals(1, result.getIdProfesor());
    }

    @Test
    public void testGetAllProfesor() {
        // Datos de ejemplo
        Long idProfesor = 1L;
        Person person = new Person();
        Profesor profesor1 = new Profesor(1L, person);
        Profesor profesor2 = new Profesor(2L, person);

        // Configuración del comportamiento simulado del repositorio
        when(profesorRepository.findAll()).thenReturn(Arrays.asList(profesor1, profesor2));

        // Llamada al método que estamos probando
        List<ProfesorOutputDto> result = profesorService.getAllProfesor();

        // Verificación de que el método del repositorio fue llamado
        verify(profesorRepository, times(1)).findAll();

        // Verificación del resultado de la llamada al método
        assertNotNull(result);
        assertEquals(2, result.size()); // Ajusta esto según el número esperado de profesores

        // Puedes hacer más verificaciones según sea necesario, por ejemplo:
        assertEquals(profesor1.getIdProfesor(), result.get(0).getIdProfesor());
        assertEquals(profesor2.getIdProfesor(), result.get(1).getIdProfesor());
    }

    @Test
    public void testAddProfesor() {
        // Datos de ejemplo
        ProfesorInputDto profesorInputDto = new ProfesorInputDto(1L, "asdijfaiml", "sodfmdsa");

        // Inicialización de Profesor y Student (pueden ser null si no son necesarios para esta prueba)
        Profesor profesor = new Profesor(/* datos del profesor */);
        Student student = new Student(/* datos del student */);

        Person person = new Person(1L, "nombreUsuario", "contrasena", "nombre", "apellido", "emailEmpresa", "emailPersonal",
                "ciudad", true, new Date(), "urlImagen", new Date(), profesor, student);

        // Configuración del comportamiento simulado del repositorio
        when(personRepository.findById(profesorInputDto.getIdPerson())).thenReturn(Optional.of(person));
        when(profesorRepository.findByPerson(person)).thenReturn(Optional.empty());
        when(studentRepository.findByPerson(person)).thenReturn(Optional.empty());

        Profesor profesorGuardado = new Profesor(/* datos del profesor guardado */);
        when(profesorRepository.save(any(Profesor.class))).thenReturn(profesorGuardado);

        // Llamada al método que estamos probando
        ProfesorOutputDto result = profesorService.addProfesor(profesorInputDto);

        // Verificación de que el método del repositorio fue llamado
        verify(personRepository, times(1)).findById(profesorInputDto.getIdPerson());
        verify(profesorRepository, times(1)).findByPerson(person);
        verify(studentRepository, times(1)).findByPerson(person);
        verify(profesorRepository, times(1)).save(any(Profesor.class));

        // Verificación del resultado de la llamada al método
        assertEquals(profesorGuardado.profesorToProfesorOutputDto(), result);
    }



}
