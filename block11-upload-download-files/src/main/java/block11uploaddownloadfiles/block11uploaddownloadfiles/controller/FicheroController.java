package block11uploaddownloadfiles.block11uploaddownloadfiles.controller;


import block11uploaddownloadfiles.block11uploaddownloadfiles.domain.Fichero;
import block11uploaddownloadfiles.block11uploaddownloadfiles.service.FicheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@RestController

public class FicheroController {
    @Autowired
    FicheroService ficheroService;

    /* //FUNCIONA LA PRIMERA PARTE DEL EJERCICIO

    @PostMapping("/subirFichero")
    public Fichero subirFichero(@RequestParam("file") MultipartFile file,
                                      @RequestParam("categoria") String categoria,
                                      @RequestParam("ruta") String ruta) throws IOException {
        // Llamar al servicio para guardar el fichero
        return ficheroService.guardarFichero(file, categoria, ruta);
    }

    @GetMapping("/descargarFicheroPorId/{id}")
    public Fichero descargarFicheroPorId(@PathVariable long id) {
        // Llamar al servicio para buscar el fichero por ID
        return ficheroService.buscarFicheroPorId(id);
    }

    @GetMapping("/descargarFicheroPorNombre/{nombre}")
    public Fichero descargarFicheroPorNombre(@PathVariable String name) {
        // Llamar al servicio para buscar el fichero por nombre
        return ficheroService.buscarFicheroPorNombre(name);
    }*/
///////////////

    @PostMapping("/upload/{tipo}")
    public Fichero subirFichero(@RequestBody MultipartFile file,
                                @RequestParam("categoria") String categoria,
                                @PathVariable String tipo) throws IOException {
        // Llamar al servicio para guardar el fichero
        return ficheroService.guardarFichero(file, categoria, tipo);
    }

    @GetMapping("/setpath")
    public ResponseEntity<String> getPatch(@RequestParam("path") String ruta) {
        return ficheroService.modificarRuta(ruta);

    }


    @GetMapping("/file")
    public ResponseEntity<Resource> descargarFichero(@RequestParam(value = "id", required = false) Long id) throws IOException {
        Resource resource = ficheroService.descargarFichero(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
