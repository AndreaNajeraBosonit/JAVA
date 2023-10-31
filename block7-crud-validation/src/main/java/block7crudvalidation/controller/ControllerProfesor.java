package block7crudvalidation.controller;

import block7crudvalidation.application.ProfesorService;
import block7crudvalidation.application.ProfesorServiceImpl;
import block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.controller.dto.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ControllerProfesor {
    @Autowired
    ProfesorService profesorService;
    @GetMapping("/{idProfesor}")
    public ResponseEntity<ProfesorOutputDto> getProfesorById(@PathVariable Long idProfesor) {
        try {

            return ResponseEntity.ok().body(profesorService.getProfesorById(idProfesor));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<ProfesorOutputDto>> getAllProfesor() {
        List<ProfesorOutputDto> profesor = profesorService.getAllProfesor();

        return ResponseEntity.ok(profesor);

    }
    @PostMapping
    public ResponseEntity<ProfesorOutputDto> addProfesor(@RequestBody ProfesorInputDto profesor) throws Exception {
        return ResponseEntity.ok().body(profesorService.addProfesor(profesor));
    }

    }




