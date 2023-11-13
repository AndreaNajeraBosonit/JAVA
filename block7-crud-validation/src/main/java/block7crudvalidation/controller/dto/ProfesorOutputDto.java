package block7crudvalidation.controller.dto;

import block7crudvalidation.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfesorOutputDto {

    Long idProfesor;
    Long idPerson;
    String coments;
    String branch;


}
