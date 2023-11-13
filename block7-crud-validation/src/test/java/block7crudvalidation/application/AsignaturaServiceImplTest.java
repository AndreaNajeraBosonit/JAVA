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
import block7crudvalidation.exceptions.EntityNotFoundException;
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
    public void testDeleteAsignaturaByIdWithAssociatedStudents() {
        // Arrange
        Long idAsignatura = 1L;
        Asignatura asignatura = new Asignatura(idAsignatura, new ArrayList<>(), "Matemáticas", "", new Date(), new Date());

        // Configura el comportamiento esperado del repositorio mock
        when(asignaturaRepository.findById(idAsignatura)).thenReturn(Optional.of(asignatura));

        Student student1 = new Student();
        Student student2 = new Student();
        List<Student> estudiantesAsociados = Arrays.asList(student1, student2);
        when(studentRepository.findByAsignaturas(asignatura)).thenReturn(estudiantesAsociados);

        // Act
        String result = asignaturaService.deleteAsignaturaById(idAsignatura);

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("asociaciones con estudiantes han sido eliminadas correctamente."));

        // Verifica que la asignatura se haya eliminado correctamente
        verify(asignaturaRepository, times(1)).deleteById(idAsignatura);

        // Verifica que se haya llamado a saveAll con la lista correcta de estudiantes asociados
        verify(studentRepository, times(1)).saveAll(estudiantesAsociados);
    }

    @Test
    public void testGetAsignaturaStudentId_ValidStudentId_NoAsignaturasAsociadas() {
        // Arrange
        Long validStudentId = 1L; // ID de un estudiante válido sin asignaturas asociadas
        when(studentRepository.findById(validStudentId)).thenReturn(Optional.of(new Student())); // Simula un estudiante sin asignaturas

        // Act
        List<AsignaturaOutputDto> result = asignaturaService.getAsignaturaStudentId(validStudentId);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
    @Test
    public void testGetAsignaturaStudentId_InternalException() {
        // Arrange
        Long validStudentId = 1L;
        when(studentRepository.findById(validStudentId)).thenReturn(Optional.of(new Student()));
        when(studentRepository.findById(validStudentId).get().getAsignaturas()).thenThrow(new RuntimeException("Error interno"));

        // Act y Assert
        assertThrows(RuntimeException.class, () -> {
            asignaturaService.getAsignaturaStudentId(validStudentId);
        });
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
    public void testAddAsignatura_ValidInput() {
        // Arrange
        AsignaturaInputDto inputDto = new AsignaturaInputDto();
        inputDto.setAsignatura("Matemáticas");
        inputDto.setComents("Comentarios sobre la asignatura");
        inputDto.setInitial_date(new Date());
        inputDto.setFinish_date(new Date());
        inputDto.setStudent(Arrays.asList(1L, 2L));

        List<Student> studentList = Arrays.asList(new Student(), new Student());

        // Configurar comportamiento esperado del repositorio mock
        when(studentRepository.findById(1L)).thenReturn(Optional.of(studentList.get(0)));
        when(studentRepository.findById(2L)).thenReturn(Optional.of(studentList.get(1)));
        when(asignaturaRepository.save(any(Asignatura.class))).thenReturn(new Asignatura());

        // Act
        AsignaturaOutputDto result = asignaturaService.addAsignatura(inputDto);

        // Assert
        assertNotNull(result);
        // Realiza más aserciones según el comportamiento específico que esperas en tu aplicación
    }

    @Test
    public void testAddAsignatura_EmptyStudentList() {
        // Arrange
        AsignaturaInputDto inputDto = new AsignaturaInputDto();
        inputDto.setStudent(new ArrayList<>());

        // Act & Assert
        assertThrows(UnprocessableEntityException.class, () -> asignaturaService.addAsignatura(inputDto));
    }
    @Test
    public void testAddAsignatura_NullStudentList() {
        // Arrange
        AsignaturaInputDto inputDto = new AsignaturaInputDto();
        inputDto.setStudent(null);

        // Act & Assert
        assertThrows(UnprocessableEntityException.class, () -> asignaturaService.addAsignatura(inputDto));
    }

    @Test
    public void testAddAsignatura_SaveReturnsNull() {
        // Arrange
        AsignaturaInputDto inputDto = new AsignaturaInputDto();
        inputDto.setStudent(Arrays.asList(1L));

        // Configurar comportamiento esperado del repositorio mock
        when(studentRepository.findById(1L)).thenReturn(Optional.of(new Student()));
        when(asignaturaRepository.save(any(Asignatura.class))).thenReturn(null);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> asignaturaService.addAsignatura(inputDto));
    }
    @Test
    public void testGetAsignaturaStudentId_ValidStudentId() {
        // Arrange
        Long idStudent = 1L;
        List<Asignatura> asignaturas = new ArrayList<>();
        asignaturas.add(new Asignatura(/* configurar según sea necesario */));
        asignaturas.add(new Asignatura(/* configurar según sea necesario */));

        Student student = new Student();
        student.setIdStudent(idStudent);
        student.setAsignaturas(asignaturas);

        // Configurar el comportamiento esperado del repositorio mock
        when(studentRepository.findById(idStudent)).thenReturn(Optional.of(student));

        // Act
        List<AsignaturaOutputDto> result = asignaturaService.getAsignaturaStudentId(idStudent);

        // Assert
        assertNotNull(result);
        assertEquals(asignaturas.size(), result.size());
        // Puedes realizar más aserciones según tus necesidades específicas
    }
    @Test
    public void testGetAsignaturaStudentId_InvalidStudentId() {
        // Arrange
        Long invalidStudentId = 999L; // Un ID de estudiante que no existe

        // Act y Assert
        assertThrows(jakarta.persistence.EntityNotFoundException.class, () -> {
            asignaturaService.getAsignaturaStudentId(invalidStudentId);
        });
    }

    // Agrega más casos de prueba según los escenarios que desees cubrir
}



