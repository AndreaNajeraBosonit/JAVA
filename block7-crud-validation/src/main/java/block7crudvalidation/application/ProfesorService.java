package block7crudvalidation.application;

import block7crudvalidation.controller.dto.PersonOutputDto;
import block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.controller.dto.ProfesorOutputDto;

import java.util.List;

public interface ProfesorService {
    ProfesorOutputDto addProfesor(ProfesorInputDto profesor) throws Exception;
    ProfesorOutputDto getProfesorById(Long IdProfesor);

    List<ProfesorOutputDto> getAllProfesor();




}
