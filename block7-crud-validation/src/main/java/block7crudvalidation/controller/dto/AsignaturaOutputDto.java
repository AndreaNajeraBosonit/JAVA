package block7crudvalidation.controller.dto;

import block7crudvalidation.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDto {

    Long idAsignatura;

    List<Long> idStudents;

    String asignatura;

    String coments;

    Date initial_date;

    Date finish_date;

}
