package block7crudvalidation.application;

import block7crudvalidation.controller.dto.*;

import java.util.List;

public interface AsignaturaService {
    List<AsignaturaOutputDto> getAllAsignatura();
    AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignatura) throws Exception;
    AsignaturaOutputDto getAsignaturaById(Long idAsignatura);

    String deleteAsignaturaById (Long idAsignatura);
    List<AsignaturaOutputDto> getAsignaturaStudentId(Long idStudent);
}
