package block7crudvalidation.application;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.*;


import block7crudvalidation.controller.dto.AsignaturaInputDto;
import block7crudvalidation.controller.dto.AsignaturaOutputDto;
import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.domain.Asignatura;

import block7crudvalidation.domain.Person;
import block7crudvalidation.domain.Student;
import block7crudvalidation.exceptions.UnprocessableEntityException;
import block7crudvalidation.repository.AsignaturaRepository;
import block7crudvalidation.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AsignaturaServiceImplTest {
    @InjectMocks
    private AsignaturaServiceImpl asignaturaService;
    @Mock
    AsignaturaRepository asignaturaRepository;
    @Mock
    StudentRepository studentRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeleteAsignaturaByIdWithoutStudents() {
        // Arrange
        Long idAsignatura = 1L;
        Asignatura asignatura = new Asignatura();
        when(asignaturaRepository.findById(idAsignatura)).thenReturn(Optional.of(asignatura));


        // Act
        String result = asignaturaService.deleteAsignaturaById(idAsignatura);

        // Assert
        assertNotNull(result);
    }


    @Test
    public void testGetAllAsignatura() {
        Asignatura asignatura1 = new Asignatura(1L, new ArrayList<>(), "mates", "", new Date(), new Date());
        Asignatura asignatura2 = new Asignatura(2L, new ArrayList<>(), "historia", "", new Date(), new Date());
        List<Asignatura> asignaturaList = Arrays.asList(asignatura1, asignatura2);

        // Configura el comportamiento esperado del repositorio mock
        when(asignaturaRepository.findAll()).thenReturn(asignaturaList);

        // Act
        List<AsignaturaOutputDto> result = asignaturaService.getAllAsignatura();

        // Assert
        // Verifica que el resultado no sea nulo y tenga el tamaño esperado
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetAsignaturaById() {
        // Arrange
        Long idAsignatura = 1L;
        Asignatura asignatura = new Asignatura(idAsignatura, new ArrayList<>(), "mates", "", new Date(), new Date());

        // Configura el comportamiento esperado del repositorio mock
        when(asignaturaRepository.findById(idAsignatura)).thenReturn(Optional.of(asignatura));

        // Act
        AsignaturaOutputDto result = asignaturaService.getAsignaturaById(idAsignatura);

        // Assert
        // Verifica que el resultado no sea nulo
        assertNotNull(result);

        // Agrega aserciones según la lógica de transformación de Asignatura a AsignaturaOutputDto si es necesario
        assertEquals("mates", result.getAsignatura()); // Ejemplo de aserción, ajusta según tu lógica de transformación
    }

    @Test
    public void testGetStudentsFromIds() {
        // Arrange
        List<Long> studentIds = new ArrayList<>();
        studentIds.add(1L);
        studentIds.add(2L);

        Student student1 = new Student();
        Student student2 = new Student();

        // Configura el comportamiento esperado del repositorio mock
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student1));
        when(studentRepository.findById(2L)).thenReturn(Optional.of(student2));

        // Act
        List<Student> result = asignaturaService.getStudentsFromIds(studentIds);

        // Assert
        // Verifica que la lista de estudiantes no sea nula y tenga el tamaño esperado
        assertNotNull(result);
        assertEquals(2, result.size());

        // Agrega más aserciones según el comportamiento específico que esperas en tu aplicación
    }

    @Test
    public void testGetterAndSetterMethods() {
        // Arrange
        Long idAsignatura = 1L;
        List<Long> idStudents = Arrays.asList(1L, 2L);
        String asignatura = "Matemáticas";
        String coments = "Comentarios de la asignatura";
        Date initialDate = new Date();
        Date finishDate = new Date();

        // Act
        AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto();
        asignaturaOutputDto.setIdAsignatura(idAsignatura);
        asignaturaOutputDto.setIdStudents(idStudents);
        asignaturaOutputDto.setAsignatura(asignatura);
        asignaturaOutputDto.setComents(coments);
        asignaturaOutputDto.setInitial_date(initialDate);
        asignaturaOutputDto.setFinish_date(finishDate);

        // Assert
        assertEquals(idAsignatura, asignaturaOutputDto.getIdAsignatura());
        assertEquals(idStudents, asignaturaOutputDto.getIdStudents());
        assertEquals(asignatura, asignaturaOutputDto.getAsignatura());
        assertEquals(coments, asignaturaOutputDto.getComents());
        assertEquals(initialDate, asignaturaOutputDto.getInitial_date());
        assertEquals(finishDate, asignaturaOutputDto.getFinish_date());
    }

    @Test
    public void testAddAsignatura() {
        // Arrange
        AsignaturaInputDto inputDto = new AsignaturaInputDto();
        inputDto.setStudent(new ArrayList<>()); // Puedes añadir estudiantes a la lista si es necesario

        List<Student> mockStudents = new ArrayList<>();
        Student student1 = new Student(/* datos del estudiante 1 */);
        Student student2 = new Student(/* datos del estudiante 2 */);
        mockStudents.add(student1);
        mockStudents.add(student2);

        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(new Student(/* datos del estudiante */)));
        when(asignaturaRepository.save(any(Asignatura.class))).thenReturn(new Asignatura(/* datos de la asignatura guardada */));

        // Act
        AsignaturaOutputDto result = asignaturaService.addAsignatura(inputDto);

        // Assert
        assertNotNull(result);
        // Realiza más aserciones según el comportamiento específico que esperas en tu aplicación
    }
    }

