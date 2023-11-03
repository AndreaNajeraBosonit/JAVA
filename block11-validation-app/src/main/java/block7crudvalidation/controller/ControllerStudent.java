package block7crudvalidation.controller;

import block7crudvalidation.application.ProfesorServiceImpl;
import block7crudvalidation.application.StudentService;
import block7crudvalidation.application.StudentServiceImpl;
import block7crudvalidation.controller.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class ControllerStudent {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentOutputDto>> getAllStudent() {
        List<StudentOutputDto> student = studentService.getAllStudent();

        return ResponseEntity.ok(student);

    }

    @PostMapping
    public ResponseEntity<StudentOutputDto> addStudent(@RequestBody StudentInputDto studentInputDto) throws Exception {
        return ResponseEntity.ok().body(studentService.addStudent(studentInputDto));
    }
    @GetMapping("/{idStudent}")
    public ResponseEntity<StudentOutputDto> getStudentById(@PathVariable Long idStudent) {
        try {

            return ResponseEntity.ok().body(studentService.getStudentById(idStudent));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }





    // Endpoint para desasignar asignaturas de un estudiante por su ID
//No aparece los id de estudiantes en asignatura pero si que existen t se eliminan

    @PostMapping("/{idStudent}/asignaturas")
    public ResponseEntity<String> asignarAsignaturasAEstudiante(@PathVariable Long idStudent, @RequestBody List<Long> idAsignatura) {
        String mensaje = studentService.asignarAsignaturas(idStudent, idAsignatura);
        return ResponseEntity.ok(mensaje);
    }
    @DeleteMapping("/{idStudent}/asignaturas")
    public ResponseEntity<String> desasignarAsignaturas(@PathVariable Long idStudent, @RequestBody List<Long> idAsignatura) {
        String mensaje = studentService.desasignarAsignaturas(idStudent, idAsignatura);
        return ResponseEntity.ok(mensaje);
    }



}
