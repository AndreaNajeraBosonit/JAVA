package block7crudvalidation.controller;

import block7crudvalidation.application.AsignaturaService;
import block7crudvalidation.controller.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/asignatura")
public class ControllerAsignatura {
    @Autowired
    AsignaturaService asignaturaService;

    @GetMapping
    public ResponseEntity<List<AsignaturaOutputDto>> getAllAsignatura() {
        List<AsignaturaOutputDto> asignatura = asignaturaService.getAllAsignatura();

        return ResponseEntity.ok(asignatura);

    }


       @GetMapping("/{idAsignatura}")
       public ResponseEntity<AsignaturaOutputDto> getAsignaturaById(@PathVariable Long idAsignatura) {
           try {

               return ResponseEntity.ok().body(asignaturaService.getAsignaturaById(idAsignatura));
           } catch (Exception e) {
               return ResponseEntity.notFound().build();
           }
       }
@PostMapping
public AsignaturaOutputDto addAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto)throws Exception {
         return asignaturaService.addAsignatura(asignaturaInputDto);
}


    @GetMapping("/idEstudiante/{idStudent}")
    public ResponseEntity<String> obtenerAsignaturasId(@PathVariable Long idStudent) {
        List<AsignaturaOutputDto> asignaturas = asignaturaService.getAsignaturaStudentId(idStudent);
        String mensaje = "El estudiante con id: " + idStudent + " esta en las siguientes asignaturas:\n";
        for(AsignaturaOutputDto asignatura : asignaturas){
            mensaje += "Id de la asignatura: " + asignatura.getIdAsignatura() + " Nombre de la asignatura: " + asignatura.getAsignatura() + "\n";
        }
        return ResponseEntity.ok().body(mensaje);
    }

    @DeleteMapping("/{idAsignatura}")
    public ResponseEntity<String> deleteAsignaturaById(@PathVariable Long idAsignatura) {
        String message = asignaturaService.deleteAsignaturaById(idAsignatura);
        return ResponseEntity.ok(message);
    }




}



