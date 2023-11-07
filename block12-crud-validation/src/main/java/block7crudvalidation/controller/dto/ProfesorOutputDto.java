package block7crudvalidation.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfesorOutputDto {

    Long idProfesor;
    Long idPerson;
    String coments;
    String branch;

}
