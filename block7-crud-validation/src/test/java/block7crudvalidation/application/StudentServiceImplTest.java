package block7crudvalidation.application;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import block7crudvalidation.controller.dto.ProfesorOutputDto;
import block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.controller.dto.StudentOutputDto;
import block7crudvalidation.domain.Asignatura;
import block7crudvalidation.domain.Person;
import block7crudvalidation.domain.Profesor;
import block7crudvalidation.domain.Student;
import block7crudvalidation.exceptions.EntityNotFoundException;
import block7crudvalidation.repository.AsignaturaRepository;
import block7crudvalidation.repository.PersonRepository;
import block7crudvalidation.repository.ProfesorRepository;
import block7crudvalidation.repository.StudentRepository;
import java.time.LocalDate;
import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;


public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private AsignaturaRepository asignaturaRepository;
    @Mock
    private PersonRepository personRepository;

    @Mock
    private ProfesorRepository profesorRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    // Método para crear una lista de estudiantes mock para pruebas
    @Test
    public void testGetterAndSetterMethods() {
        // Arrange
        Long idStudent = 1L;
        Long idPerson = 2L;
        int numHoursWeek = 10;
        String comments = "Student comments";
        Long idProfesor = 3L;
        String branch = "Branch";

        // Act
        StudentOutputDto studentOutputDto = new StudentOutputDto();
        studentOutputDto.setIdStudent(idStudent);
        studentOutputDto.setIdPerson(idPerson);
        studentOutputDto.setNum_hours_week(numHoursWeek);
        studentOutputDto.setComents(comments);
        studentOutputDto.setIdProfesor(idProfesor);
        studentOutputDto.setBranch(branch);

        // Assert
        assertEquals(idStudent, studentOutputDto.getIdStudent());
        assertEquals(idPerson, studentOutputDto.getIdPerson());
        assertEquals(numHoursWeek, studentOutputDto.getNum_hours_week());
        assertEquals(comments, studentOutputDto.getComents());
        assertEquals(idProfesor, studentOutputDto.getIdProfesor());
        assertEquals(branch, studentOutputDto.getBranch());
    }

    @Test
    public void testConstructors() {
        // Crear una instancia utilizando el constructor sin argumentos
        StudentOutputDto studentOutputDto1 = new StudentOutputDto();
        assertNotNull(studentOutputDto1);

        // Crear una instancia utilizando el constructor con argumentos
        StudentOutputDto studentOutputDto2 = new StudentOutputDto(1L, 2L, 10, "Comentario", 3L, "Branch");
        assertNotNull(studentOutputDto2);

        // Crear una instancia utilizando el constructor de copia
        StudentOutputDto studentOutputDto3 = new StudentOutputDto(studentOutputDto2);
        assertNotNull(studentOutputDto3);

        // Verificar que los valores se han copiado correctamente
        assertEquals(studentOutputDto2, studentOutputDto3);
    }
    @Test
    public void testGettersAndSetters() {
        // Crear una instancia
        StudentOutputDto studentOutputDto = new StudentOutputDto();

        // Configurar valores utilizando setters
        studentOutputDto.setIdStudent(1L);
        studentOutputDto.setIdPerson(2L);
        studentOutputDto.setNum_hours_week(10);
        studentOutputDto.setComents("Comentario");
        studentOutputDto.setIdProfesor(3L);
        studentOutputDto.setBranch("Branch");

        // Verificar los valores utilizando getters
        assertEquals(1L, studentOutputDto.getIdStudent().longValue());
        assertEquals(2L, studentOutputDto.getIdPerson().longValue());
        assertEquals(10, studentOutputDto.getNum_hours_week());
        assertEquals("Comentario", studentOutputDto.getComents());
        assertEquals(3L, studentOutputDto.getIdProfesor().longValue());
        assertEquals("Branch", studentOutputDto.getBranch());
    }

    @Test
    public void testGetAllStudent() {
        // Configurar el comportamiento del mock para devolver una lista de estudiantes simulada
        Person person = new Person(/*...*/);
        Profesor profesor = new Profesor(/*...*/);
        List<Asignatura> asignaturas = Arrays.asList(new Asignatura(/*...*/), new Asignatura(/*...*/));

// Crear la instancia de Student
        Student student1 = new Student();
        student1.setNum_hours_week(20); // Asignar un valor para num_hours_week
        student1.setComents("Comentario"); // Asignar un valor para coments
        student1.setBranch("Frontend"); // Asignar un valor para branch
        student1.setPerson(person); // Asignar la instancia de Person
        student1.setProfesor(profesor); // Asignar la instancia de Profesor
        student1.setAsignaturas(asignaturas); // Asignar la lista de Asignaturas
        Student student2 = new Student();
        student1.setNum_hours_week(20); // Asignar un valor para num_hours_week
        student1.setComents("Comentario"); // Asignar un valor para coments
        student1.setBranch("Frontend"); // Asignar un valor para branch
        student1.setPerson(person); // Asignar la instancia de Person
        student1.setProfesor(profesor); // Asignar la instancia de Profesor
        student1.setAsignaturas(asignaturas); // Asignar la lista de Asignaturas
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));

        // Llamar al método que se va a probar
        List<StudentOutputDto> result = studentService.getAllStudent();

        // Verificar los resultados
        assertEquals(2, result.size());
        // Puedes agregar más aserciones según sea necesario
    }


    @Test
    public void testGetStudentById() {
        // Arrange
        Long idStudent = 1L;
        Student student = new Student(); // Puedes configurar este objeto según sea necesario
        when(studentRepository.findById(idStudent)).thenReturn(Optional.of(student));

        // Act
        StudentOutputDto result = studentService.getStudentById(idStudent);

        // Assert
        // Realiza las aserciones necesarias, por ejemplo:
        assertNotNull(result);
        // Puedes agregar más aserciones según sea necesario
    }
    @Test
    public void testAsignarAsignaturas() {
        // Arrange
        Long idStudent = 1L;
        List<Long> idAsignaturas = Arrays.asList(101L, 102L); // IDs de asignaturas simuladas

        Student student = new Student(); // Puedes configurar este objeto según sea necesario
        when(studentRepository.findById(idStudent)).thenReturn(Optional.of(student));

        List<Asignatura> asignaturas = Arrays.asList(
                new Asignatura(101L, Arrays.asList(new Student(/*...*/), new Student(/*...*/)), "Matemáticas", "Comentario1", new Date(), null),
                new Asignatura(102L, Arrays.asList(new Student(/*...*/), new Student(/*...*/)), "Historia", "Comentario2", new Date(), null)
        ); // Puedes configurar estos objetos según sea necesario
        when(asignaturaRepository.findAllById(idAsignaturas)).thenReturn(asignaturas);

        // Act
        String result = studentService.asignarAsignaturas(idStudent, idAsignaturas);

        // Assert
        assertNotNull(result);
        assertEquals("Asignaturas asignadas correctamente al estudiante con ID: " + idStudent, result);

        // Realiza más aserciones según sea necesario, por ejemplo, verifica que las asignaturas se hayan agregado al estudiante
        assertEquals(asignaturas.size(), student.getAsignaturas().size());
        assertTrue(student.getAsignaturas().containsAll(asignaturas));
    }
    @Test
    public void testDesasignarAsignaturas() {
        // Arrange
        Long idStudent = 1L;
        List<Long> idAsignaturas = Arrays.asList(101L, 102L); // IDs de asignaturas simuladas

        Student student = new Student(); // Puedes configurar este objeto según sea necesario
        when(studentRepository.findById(idStudent)).thenReturn(Optional.of(student));

        List<Asignatura> asignaturas = Arrays.asList(
                new Asignatura(101L, new ArrayList<>(), "Matemáticas", "Comentario1", null, null),
                new Asignatura(102L, new ArrayList<>(), "Historia", "Comentario2", null, null)
        ); // Puedes configurar estos objetos según sea necesario
        when(asignaturaRepository.findAllById(idAsignaturas)).thenReturn(asignaturas);

        // Act
        String result = studentService.desasignarAsignaturas(idStudent, idAsignaturas);

        // Assert
        assertNotNull(result);
        assertEquals("Asignaturas desasignadas correctamente del estudiante con ID: " + idStudent, result);

        // Verifica que las asignaturas se hayan removido correctamente del estudiante
        assertTrue(student.getAsignaturas().isEmpty());

        // Puedes agregar más aserciones según sea necesario
    }
    @Test
    public void testAddStudent() {
        // Arrange
        StudentInputDto studentInputDto = new StudentInputDto();
        studentInputDto.setIdPerson(1L);  // Configura el ID de la persona según tus necesidades
        studentInputDto.setIdProfesor(2L); // Configura el ID del profesor según tus necesidades
        Person person = new Person(/* Configurar según sea necesario */);
        Profesor profesor = new Profesor(/* Configurar según sea necesario */);

        when(personRepository.findById(studentInputDto.getIdPerson())).thenReturn(Optional.of(person));
        when(profesorRepository.findById(studentInputDto.getIdProfesor())).thenReturn(Optional.of(profesor));
        when(profesorRepository.findByPerson(person)).thenReturn(Optional.empty());
        when(studentRepository.findByPerson(person)).thenReturn(Optional.empty());

        Student savedStudent = new Student(/* Configurar según sea necesario */);
        when(studentRepository.save(any())).thenReturn(savedStudent);

        // Act
        StudentOutputDto result = studentService.addStudent(studentInputDto);

        // Assert
        assertNotNull(result);

        // Verifica que se haya llamado al método save del repositorio
        verify(studentRepository, times(1)).save(any());

        // Verifica que el profesor se haya actualizado con el nuevo estudiante
        verify(profesorRepository, times(1)).save(profesor);
        assertTrue(profesor.getStudents().contains(savedStudent));

        // Puedes agregar más aserciones según sea necesario
    }

}

    // Puedes agregar más casos de prueba según sea necesario

