package block7crudvalidation.application;


import block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.controller.dto.ProfesorOutputDto;

import block7crudvalidation.domain.Person;
import block7crudvalidation.domain.Profesor;
import block7crudvalidation.domain.Student;
import block7crudvalidation.exceptions.EntityNotFoundException;
import block7crudvalidation.repository.PersonRepository;
import block7crudvalidation.repository.ProfesorRepository;
import block7crudvalidation.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ModelMapper modelMapper;



    @Override
    public ProfesorOutputDto addProfesor( @RequestBody ProfesorInputDto profesor) {
        Person person = personRepository.findById(profesor.getIdPerson()).orElseThrow(() -> new EntityNotFoundException("No se encontro la persona con Id " + profesor.getIdPerson()));
        Optional<Profesor> profesorAux = profesorRepository.findByPerson(person);
        if(profesorAux.isPresent()){throw new EntityNotFoundException("Esa persona ya esta asociada con un profesor");}
        Optional<Student> student = studentRepository.findByPerson(person);
        /*
        if(student.isPresent()){throw new EntityNotFoundException("Esa persona ya esta asociada con un alumno");}*/
        Profesor profesor1 = new Profesor(profesor);
        profesor1.setPerson(person);
        return profesorRepository.save(profesor1).profesorToProfesorOutputDto();
    }

//    @Override
//    public ProfesorOutputDto addProfesor(@RequestBody ProfesorInputDto profesorInputDto) {
//        Person person = personRepository.findById(profesorInputDto.getIdPerson())
//                .orElseThrow(() -> new EntityNotFoundException("No se encontró la persona con Id " + profesorInputDto.getIdPerson()));
//
//        Optional<Profesor> profesorAux = profesorRepository.findByPerson(person);
//
//        if (profesorAux.isPresent()) {
//            throw new EntityNotFoundException("Esa persona ya está asociada con un profesor");
//        }
//
//        // Crear una nueva instancia de Profesor
//        Profesor profesor = new Profesor(profesorInputDto);
//
//        // Establecer la relación con la persona
//        profesor.setPerson(person);
//
//        // Guardar el profesor en el repositorio
//        Profesor profesorGuardado = profesorRepository.save(profesor);
//
//        // Convertir y devolver el resultado
//        return profesorGuardado.profesorToProfesorOutputDto();
//    }

    //Peticion http://localhost:8080/profesor/1
    @Override
    public ProfesorOutputDto getProfesorById(Long idProfesor) {

        return profesorRepository.findById(idProfesor).orElseThrow()
                .profesorToProfesorOutputDto();
    }

    @Override
    public List<ProfesorOutputDto> getAllProfesor() {
        List<Profesor> profesor = profesorRepository.findAll();
        return profesor.stream()
                .map(Profesor::profesorToProfesorOutputDto)
                .collect(Collectors.toList());
    }


}
