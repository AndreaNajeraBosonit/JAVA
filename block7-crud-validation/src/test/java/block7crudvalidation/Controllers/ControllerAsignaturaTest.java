package block7crudvalidation.Controllers;


import block7crudvalidation.application.AsignaturaService;
        import block7crudvalidation.controller.ControllerAsignatura;
        import block7crudvalidation.controller.dto.AsignaturaInputDto;
        import block7crudvalidation.controller.dto.AsignaturaOutputDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
        import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;

        import java.util.Arrays;
        import java.util.List;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.ArgumentMatchers.*;
        import static org.mockito.Mockito.*;

public class ControllerAsignaturaTest {

    @Mock
    private AsignaturaService asignaturaService;

    @InjectMocks
    private ControllerAsignatura controllerAsignatura;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetAllAsignatura() {
        // Arrange
        List<AsignaturaOutputDto> asignaturaList = Arrays.asList(new AsignaturaOutputDto(), new AsignaturaOutputDto());
        when(asignaturaService.getAllAsignatura()).thenReturn(asignaturaList);

        // Act
        ResponseEntity<List<AsignaturaOutputDto>> responseEntity = controllerAsignatura.getAllAsignatura();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(asignaturaList, responseEntity.getBody());
    }

    @Test
    public void testGetAsignaturaById_Success() {
        // Arrange
        Long idAsignatura = 1L;
        AsignaturaOutputDto asignaturaOutputDto = new AsignaturaOutputDto();
        when(asignaturaService.getAsignaturaById(idAsignatura)).thenReturn(asignaturaOutputDto);

        // Act
        ResponseEntity<AsignaturaOutputDto> responseEntity = controllerAsignatura.getAsignaturaById(idAsignatura);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(asignaturaOutputDto, responseEntity.getBody());
    }



    @Test
    public void testAddAsignatura() throws Exception {
        // Arrange
        AsignaturaInputDto inputDto = new AsignaturaInputDto();
        AsignaturaOutputDto outputDto = new AsignaturaOutputDto();
        when(asignaturaService.addAsignatura(any(AsignaturaInputDto.class))).thenReturn(outputDto);

        // Act
        AsignaturaOutputDto result = controllerAsignatura.addAsignatura(inputDto);

        // Assert
        assertEquals(outputDto, result);
    }


    @Test
    public void testDeleteAsignaturaById() {
        // Arrange
        Long idAsignatura = 1L;
        String message = "Asignatura eliminada correctamente";
        when(asignaturaService.deleteAsignaturaById(idAsignatura)).thenReturn(message);

        // Act
        ResponseEntity<String> responseEntity = controllerAsignatura.deleteAsignaturaById(idAsignatura);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(message, responseEntity.getBody());
    }
}
