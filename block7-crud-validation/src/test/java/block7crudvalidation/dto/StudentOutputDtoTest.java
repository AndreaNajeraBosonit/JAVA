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
        Assertions.assertEquals(studentOutputDto,studentOutputDto1);
    }


}
