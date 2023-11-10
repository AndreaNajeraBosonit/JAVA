package block7crudvalidation.application;

import block7crudvalidation.controller.dto.*;
import block7crudvalidation.domain.Asignatura;
import block7crudvalidation.domain.Student;
import block7crudvalidation.repository.AsignaturaRepository;
import block7crudvalidation.repository.PersonRepository;
import block7crudvalidation.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsignaturaServiceImpl  implements AsignaturaService{
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PersonRepository personRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<AsignaturaOutputDto> getAllAsignatura() {
        List<Asignatura> asignatura = asignaturaRepository.findAll();
        return asignatura.stream()
                .map(Asignatura::asignaturaToAsignaturaOutputDto)
                .collect(Collectors.toList());
    }


    @Override
    public AsignaturaOutputDto getAsignaturaById(Long idStudent) {
        Asignatura asignatura = asignaturaRepository.findById(idStudent).orElseThrow(() ->{throw new EntityNotFoundException("No se encontró el Asignatura con ID: " + idStudent); });
        return asignatura.asignaturaToAsignaturaOutputDto();
    }

    public List<Student> getStudentsFromIds(List<Long> studentIds) {
        if(studentIds != null) {
            return studentIds.stream()
                    .map(studentId -> studentRepository.findById(studentId)
                            .orElseThrow(() -> new EntityNotFoundException("No se encontró el estudiante con Id " + studentId)))
                    .collect(Collectors.toList());
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto) {
        List<Student> studentList = getStudentsFromIds(asignaturaInputDto.getStudent());

        // Verificar si la lista student está inicializada
        if (studentList == null) {
            studentList = new ArrayList<>();
        }

        Asignatura asignatura = new Asignatura(asignaturaInputDto);
        asignatura.setStudent(studentList);
        AsignaturaOutputDto asignaturaOutputDto = asignaturaRepository.save(asignatura).asignaturaToAsignaturaOutputDto();

        // Verificar si la lista student tiene elementos antes de usar forEach
        if (studentList != null) {
            studentList.forEach(student -> {
                student.getAsignaturas().add(asignatura);
                studentRepository.save(student);
            });
        }

        return asignaturaOutputDto;
    }

    @Override
    public List<AsignaturaOutputDto> getAsignaturaStudentId(Long idStudent) {
        Student student = studentRepository.findById(idStudent).orElseThrow(() ->{throw new EntityNotFoundException("No se encontró el estudiante "); });
        return  student.getAsignaturas().stream()

                .map(Asignatura::asignaturaToAsignaturaOutputDto)
                .collect(Collectors.toList());

    }
/*
    @Override
    public String deleteAsignaturaById(Long idAsignatura) {
        if (asignaturaRepository.existsById(idAsignatura)) {
            asignaturaRepository.deleteById(idAsignatura);
            return "La Asignatura con id " + idAsignatura + " se ha eliminado correctamente";
        } else {
            return "la Asignatura con id  " + idAsignatura + " no ese encuentra";
        }

    }
    */


    @Override
    public String deleteAsignaturaById(Long idAsignatura) {
        Optional<Asignatura> asignaturaOptional = asignaturaRepository.findById(idAsignatura);

        if (asignaturaOptional.isPresent()) {
            Asignatura asignatura = asignaturaOptional.get();

            // Obtener y eliminar los estudiantes asociados a la asignatura (si hay alguno)
            List<Student> estudiantesAsociados = studentRepository.findByAsignaturas(asignatura);
            estudiantesAsociados.forEach(student -> student.getAsignaturas().remove(asignatura));
            studentRepository.saveAll(estudiantesAsociados);

            // Eliminar la asignatura
            asignaturaRepository.deleteById(idAsignatura);

            return "La asignatura con ID " + idAsignatura + " y sus asociaciones con estudiantes han sido eliminadas correctamente.";
        } else {
            return "No se encontró ninguna asignatura con el ID " + idAsignatura;
        }
    }



}
