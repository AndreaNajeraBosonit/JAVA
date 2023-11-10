package block7crudvalidation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDtoTest {

    Long idAsignatura;

    List<Long> idStudents;

    String asignatura;

    String coments;

    Date initialDate;

    Date finishDdate;

}
