package block7crudvalidation.Exception;

import block7crudvalidation.exceptions.EntityNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntityNotFoundExceptionTest {

    @Test
    public void testConstructor() {
        // Arrange
        String errorMessage = "Entity not found";

        // Act
        EntityNotFoundException exception = new EntityNotFoundException(errorMessage);

        // Assert
        assertEquals(errorMessage, exception.getMessage());
    }

    // Puedes agregar más pruebas según sea necesario
}
