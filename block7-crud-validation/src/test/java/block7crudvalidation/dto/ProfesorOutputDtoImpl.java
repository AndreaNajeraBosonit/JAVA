package block7crudvalidation.dto;
import java.util.Collections;

import block7crudvalidation.domain.Profesor;
import org.junit.Before;
import org.junit.Test;

import block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.controller.dto.ProfesorOutputDto;
import block7crudvalidation.domain.Person;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfesorOutputDtoImpl {
    private Profesor profesor;

    @Before
    public void setUp() {
        profesor = new Profesor();
    }

    @Test
    public void testProfesorOutputDtoConversion() {
        // Datos de ejemplo
        Long idProfesor = 1L;
        Long idPerson = 2L;
        String coments = "Comentarios";
        String branch = "Branch";

        // Configuración del objeto Profesor
        profesor.setIdProfesor(idProfesor);
        Person person = new Person();
        person.setIdPerson(idPerson);
        profesor.setPerson(person);
        profesor.setComents(coments);
        profesor.setBranch(branch);

        // Llamada al método de conversión
        ProfesorOutputDto profesorOutputDto = profesor.profesorToProfesorOutputDto();

        // Verificaciones
        assertNotNull(profesorOutputDto);
        assertEquals(idProfesor, profesorOutputDto.getIdProfesor());
        assertEquals(idPerson, profesorOutputDto.getIdPerson());
        assertEquals(coments, profesorOutputDto.getComents());
        assertEquals(branch, profesorOutputDto.getBranch());
    }
    @Test
    public void testProfesorInputDtoConstructor() {
        // Datos de ejemplo
        ProfesorInputDto profesorInputDto = new ProfesorInputDto();
        profesorInputDto.setComents("Comentarios");
        profesorInputDto.setBranch("Branch");

        // Configuración del objeto Profesor
        profesor = new Profesor(profesorInputDto);

        // Verificaciones
        assertNotNull(profesor);
        assertEquals(profesorInputDto.getComents(), profesor.getComents());
        assertEquals(profesorInputDto.getBranch(), profesor.getBranch());
    }
    @Test
    public void testGetIdPerson() {
        // Datos de ejemplo
        Long idPerson = 1L;

        // Configuración del objeto Profesor
        Person person = new Person();
        person.setIdPerson(idPerson);
        profesor.setPerson(person);

        // Llamada al método que estamos probando
        Long result = profesor.getIdPerson();

        // Verificaciones
        assertEquals(idPerson, result);
    }


}
