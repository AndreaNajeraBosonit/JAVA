package block7crudvalidation.Exception;

import block7crudvalidation.exceptions.CustomError;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CustomErrorTest {

    @Test
    public void testDefaultConstructor() {
        // Arrange
        CustomError customError = new CustomError();

        // Act & Assert
        assertEquals(null, customError.getTimestamp());
        assertEquals(0, customError.getHttpCode());
        assertEquals(null, customError.getMensaje());
    }

    @Test
    public void testParameterizedConstructor() {
        // Arrange
        Date timestamp = new Date();
        int httpCode = 404;
        String mensaje = "Not Found";

        // Act
        CustomError customError = new CustomError(timestamp, httpCode, mensaje);

        // Assert
        assertEquals(timestamp, customError.getTimestamp());
        assertEquals(httpCode, customError.getHttpCode());
        assertEquals(mensaje, customError.getMensaje());
    }

    @Test
    public void testSettersAndGetters() {
        // Arrange
        CustomError customError = new CustomError();
        Date timestamp = new Date();
        int httpCode = 500;
        String mensaje = "Internal Server Error";

        // Act
        customError.setTimestamp(timestamp);
        customError.setHttpCode(httpCode);
        customError.setMensaje(mensaje);

        // Assert
        assertEquals(timestamp, customError.getTimestamp());
        assertEquals(httpCode, customError.getHttpCode());
        assertEquals(mensaje, customError.getMensaje());
    }

    // Agrega más pruebas según sea necesario
}
