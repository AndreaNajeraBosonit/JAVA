package block7crudvalidation.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto  {

    Long idStudent;
    Long idPerson;
    int num_hours_week;
    String coments;
    Long idProfesor;
    String branch;
  // Long idAsignatura;



    public StudentOutputDto(StudentOutputDto studentOutputDto){
        this.idStudent = studentOutputDto.idStudent;
        this.idPerson = studentOutputDto.idPerson;
        this.num_hours_week = studentOutputDto.num_hours_week;
        this.coments = studentOutputDto.coments;
        this.idProfesor = studentOutputDto.idProfesor;
        this.branch = studentOutputDto.branch;
    }
}

