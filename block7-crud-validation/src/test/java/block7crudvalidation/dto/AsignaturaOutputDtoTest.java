package block7crudvalidation.controller.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AsignaturaOutputDtoTest {

    @Test
    public void testGetterAndSetterMethods() {
        // Arrange
        Long idAsignatura = 1L;
        List<Long> idStudents = Arrays.asList(1L, 2L);
        String asignatura = "Matemáticas";
        String coments = "Comentarios sobre la asignatura";
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
    public void testConstructorWithoutArguments() {
        // Arrange & Act
        AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto();

        // Assert
        assertNotNull(asignaturaOutputDto);
    }
    @Test
    public void testConstructorWithArguments() {
        // Arrange
        Long idAsignatura = 1L;
        List<Long> idStudents = Arrays.asList(1L, 2L);
        String asignatura = "Matemáticas";

        // Act
        AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto();
        asignaturaOutputDto.setIdAsignatura(idAsignatura);
        asignaturaOutputDto.setIdStudents(idStudents);
        asignaturaOutputDto.setAsignatura(asignatura);

        // Assert
        assertNotNull(asignaturaOutputDto);
        assertEquals(idAsignatura, asignaturaOutputDto.getIdAsignatura());
        assertEquals(idStudents, asignaturaOutputDto.getIdStudents());
        assertEquals(asignatura, asignaturaOutputDto.getAsignatura());
    }



    // Puedes agregar más casos de prueba según sea necesario

}
