package block7crudvalidation.controller.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.LongBinaryOperator;
@Data
@AllArgsConstructor

@NoArgsConstructor
public class StudentInputDto {

    //Long idStudent;
    Long idPerson;
    int num_hours_week;
    Long idProfesor;

    String coments;
    String branch;

   // Long idAsignatura;




 }