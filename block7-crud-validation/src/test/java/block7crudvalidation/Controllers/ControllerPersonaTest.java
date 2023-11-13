package block7crudvalidation.Controllers;

import block7crudvalidation.controller.ControllerPersona;
import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.controller.dto.PersonOutputDto;
import block7crudvalidation.application.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ControllerPersonaTest {

    @InjectMocks
    private ControllerPersona controllerPersona;

    @Mock
    private PersonService personService;  // Asegúrate de que esta sea la misma clase que estás usando en ControllerPersona


}

