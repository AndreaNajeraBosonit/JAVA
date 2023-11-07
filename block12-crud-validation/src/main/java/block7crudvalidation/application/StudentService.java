package block7crudvalidation.application;

import block7crudvalidation.controller.dto.*;

import java.util.List;

public interface StudentService {


    List<StudentOutputDto> getAllStudent();

    StudentOutputDto addStudent(StudentInputDto studentInputDto) throws Exception;
    StudentOutputDto getStudentById(Long idStudent);
    String asignarAsignaturas(Long idStudent, List<Long> idAsignatura);

    String desasignarAsignaturas(Long idStudent, List<Long> idAsignatura);
}
