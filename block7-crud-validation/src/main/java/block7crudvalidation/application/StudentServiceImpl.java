package block7crudvalidation.application;


import block7crudvalidation.controller.dto.*;
import block7crudvalidation.domain.Asignatura;
import block7crudvalidation.domain.Person;
import block7crudvalidation.domain.Profesor;
import block7crudvalidation.domain.Student;
import block7crudvalidation.exceptions.EntityNotFoundException;
import block7crudvalidation.repository.AsignaturaRepository;
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
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    PersonRepository personRepository;
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<StudentOutputDto> getAllStudent() {
        List<Student> student = studentRepository.findAll();
        return student.stream()
                .map(Student::studentToStudentOutputDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentOutputDto addStudent(@RequestBody StudentInputDto studentInputDto) {


        Person person = personRepository.findById(studentInputDto.getIdPerson()).orElseThrow(() -> new EntityNotFoundException("No se encontro la persona con Id " + studentInputDto.getIdPerson()));
        Profesor profesor = profesorRepository.findById(studentInputDto.getIdProfesor()).orElseThrow(() -> new EntityNotFoundException("No se encontro el profesor con Id " + studentInputDto.getIdProfesor()));



        //excepcion para que si hay un profsor asignado no se pueda asignar a un estudiante
        Optional<Profesor> profesorOptional = profesorRepository.findByPerson(person);
        if (profesorOptional.isPresent()) {
            throw new EntityNotFoundException("Esa persona ya está asociada con un profesor");
        }

        Optional<Student> studentOptional = studentRepository.findByPerson(person);
        if (studentOptional.isPresent()) {
            throw new EntityNotFoundException("Esa persona ya está asociada con un estudiante");
        }

        Student estudiante = new Student(studentInputDto);
        estudiante.setPerson(person);
        estudiante.setProfesor(profesor);
        StudentOutputDto studentOutputDto = studentRepository.save(estudiante).studentToStudentOutputDto();
        profesor.getStudents().add(estudiante);
        profesorRepository.save(profesor);
        return studentOutputDto;
    }
    //Peticion http://localhost:8080/student/1
    @Override
    public StudentOutputDto getStudentById(Long idStudent) {
        return studentRepository.findById(idStudent).orElseThrow()
                .studentToStudentOutputDto();
    }


    public String asignarAsignaturas(Long idStudent, List<Long> idAsignatura) {
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con ID: " + idStudent));

        List<Asignatura> asignaturas = asignaturaRepository.findAllById(idAsignatura);
        student.getAsignaturas().addAll(asignaturas);
        studentRepository.save(student);

        return "Asignaturas asignadas correctamente al estudiante con ID: " + idStudent;
    }

    public String desasignarAsignaturas (Long idStudent, List < Long > idAsignatura){
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con ID: " + idStudent));

        List<Asignatura> asignaturas = asignaturaRepository.findAllById(idAsignatura);
        student.getAsignaturas().removeAll(asignaturas);
        studentRepository.save(student);

        return "Asignaturas desasignadas correctamente del estudiante con ID: " + idStudent;
    }


}