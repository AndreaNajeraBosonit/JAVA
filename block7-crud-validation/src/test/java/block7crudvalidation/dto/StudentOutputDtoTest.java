package block7crudvalidation.dto;

import block7crudvalidation.application.StudentService;
import block7crudvalidation.controller.dto.PersonOutputDto;
import block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.controller.dto.StudentOutputDto;
import block7crudvalidation.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentOutputDtoTest {
    @InjectMocks
    StudentOutputDto studentOutputDto;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentService studentService;



    public StudentOutputDtoTest() {
        studentOutputDto = new StudentOutputDto(1L,1L,12,"",1L,"");
    }

    @Test
    public void ConstructorOutputTest(){
        StudentOutputDto studentOutputDto1 = new StudentOutputDto(studentOutputDto);
        assertEquals(studentOutputDto,studentOutputDto1);
    }

    @Test
    public void testConstructorWithArguments() {
        // Arrange
        Long idStudent = 1L;
        Long idPerson = 2L;
        int numHoursWeek = 10;
        String comments = "Some comments";
        Long idProfesor = 3L;
        String branch = "Math";

        // Act
        StudentOutputDto studentOutputDto = new StudentOutputDto(idStudent, idPerson, numHoursWeek, comments, idProfesor, branch);

        // Assert
        assertNotNull(studentOutputDto);
        assertEquals(idStudent, studentOutputDto.getIdStudent());
        assertEquals(idPerson, studentOutputDto.getIdPerson());
        assertEquals(numHoursWeek, studentOutputDto.getNum_hours_week());
        assertEquals(comments, studentOutputDto.getComents());
        assertEquals(idProfesor, studentOutputDto.getIdProfesor());
        assertEquals(branch, studentOutputDto.getBranch());
    }
    @Test
    public void testCopyConstructor() {
        // Arrange
        StudentOutputDto originalDto = new StudentOutputDto(1L, 2L, 10, "Some comments", 3L, "Math");

        // Act
        StudentOutputDto copiedDto = new StudentOutputDto(originalDto);

        // Assert
        assertNotNull(copiedDto);
        assertEquals(originalDto.getIdStudent(), copiedDto.getIdStudent());
        assertEquals(originalDto.getIdPerson(), copiedDto.getIdPerson());
        assertEquals(originalDto.getNum_hours_week(), copiedDto.getNum_hours_week());
        assertEquals(originalDto.getComents(), copiedDto.getComents());
        assertEquals(originalDto.getIdProfesor(), copiedDto.getIdProfesor());
        assertEquals(originalDto.getBranch(), copiedDto.getBranch());
    }
}
