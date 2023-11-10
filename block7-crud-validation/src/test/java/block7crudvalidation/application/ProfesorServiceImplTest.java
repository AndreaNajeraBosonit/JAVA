package block7crudvalidation.application;
/*
import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.controller.dto.ProfesorOutputDto;
import block7crudvalidation.domain.Person;
import block7crudvalidation.domain.Profesor;
import block7crudvalidation.exceptions.UnprocessableEntityException;
import block7crudvalidation.repository.ProfesorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProfesorServiceImplTest {

    @Mock
    private ProfesorRepository profesorRepository;

    @InjectMocks
    private ProfesorServiceImpl profesorService;
    @Mock
    private Optional modelMapper;

    @Test
    public void getProfesorTest()throws Exception  {
        // Obtener profesor existente

            // Arrange
            when(profesorRepository.findById(1L)).thenReturn(java.util.Optional.empty());

            EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
                profesorService.getProfesorById(1L);
            });


            String actualMessage = exception.getMessage();

        }

    @Test
    public void testAddProfesor() {
        ProfesorInputDto profesorInputDto = new ProfesorInputDto();
        profesorInputDto.setBranch("testProfesor");
        profesorInputDto.setComents("invalidemail");

        // Verificar que se lance la excepción UnprocessableEntityException
        assertThrows(UnprocessableEntityException.class, () -> {
            profesorService.addProfesor(profesorInputDto);
        });
    }

    @Test
    public void testGetById() throws Exception {
        // Arrange
        when(profesorRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            profesorService.getProfesorById(1L);
        });


        String actualMessage = exception.getMessage();

    }
    }

*/