package block7crudvalidation.application;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.controller.dto.StudentOutputDto;
import block7crudvalidation.domain.Person;
import block7crudvalidation.domain.Profesor;
import block7crudvalidation.domain.Student;
import block7crudvalidation.repository.PersonRepository;
import block7crudvalidation.repository.ProfesorRepository;
import block7crudvalidation.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@ExtendWith(MockitoExtension.class)


public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private ProfesorRepository profesorRepository;

    @InjectMocks
    private StudentServiceImpl studentService;
    @BeforeEach
    public void setup() {
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
    public void testAddStudent() {
        // Arrange
        StudentInputDto studentInputDto = new StudentInputDto(/* datos del estudiante */);
        Person person = new Person(/* datos de la persona */);
        Profesor profesor = new Profesor(/* datos del profesor */);

        Mockito.when(personRepository.findById(any())).thenReturn(Optional.of(person));
        Mockito.when(profesorRepository.findById(any())).thenReturn(Optional.of(profesor));
        Mockito.when(profesorRepository.findByPerson(any(Person.class))).thenReturn(Optional.empty());
        Mockito.when(studentRepository.findByPerson(any(Person.class))).thenReturn(Optional.empty());
        Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(new Student(/* datos del estudiante */));
        // Aquí puedes personalizar la lógica según tus necesidade

// Act - invocar el método que estamos probando
        StudentOutputDto result = studentService.addStudent(studentInputDto);

        // Assert
        // Verifica que se devuelva un resultado no nulo
        Assert.assertNotNull(result);
        // Puedes agregar más aserciones según las propiedades del objeto StudentOutputDto

        // Verifica que se haya llamado al método save en el repositorio de estudiantes
        verify(studentRepository, times(1)).save(any(Student.class));
        // Puedes agregar más verificaciones según la lógica específica que esperas en tu aplicación
    }
}
