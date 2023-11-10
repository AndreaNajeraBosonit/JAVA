package block7crudvalidation.dto;

import block7crudvalidation.controller.dto.PersonOutputDto;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersonOutputDtoTest {

    @Test
    public void testPersonOutputDto() {
        // Arrange
        Long idPerson = null;
        String usuario = null;
        // Resto de los atributos...

        // Act
        PersonOutputDto personOutputDto = new PersonOutputDto();

        // Assert
        assertEquals(idPerson, personOutputDto.getIdPerson());
        assertEquals(usuario, personOutputDto.getUsuario());
        // Verifica otros atributos...
    }
}
