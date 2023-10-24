package block7crudvalidation.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(UnprocessableEntityException.class)
    //Manejar excepcion 422
  /*  public ResponseEntity<String> handleUnprocessableEntityException(UnprocessableEntityException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
    }*/
    public ResponseEntity<CustomError> handleUnprocessableEntityException(UnprocessableEntityException ex) {
        CustomError customError = new CustomError();
        customError.setTimestamp(new Date());
        customError.setHttpCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        customError.setMensaje(ex.getMessage());
        ex.printStackTrace();

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomError> handleEntityNotFoundException(EntityNotFoundException ex) {
        CustomError customError = new CustomError();
        customError.setTimestamp(new Date());
        customError.setHttpCode(HttpStatus.NOT_FOUND.value());
        customError.setMensaje(ex.getMessage());
        ex.printStackTrace();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customError);
    }

}
