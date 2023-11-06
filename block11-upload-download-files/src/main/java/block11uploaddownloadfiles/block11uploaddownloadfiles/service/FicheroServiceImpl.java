package block11uploaddownloadfiles.block11uploaddownloadfiles.service;


import block11uploaddownloadfiles.block11uploaddownloadfiles.domain.Fichero;
import block11uploaddownloadfiles.block11uploaddownloadfiles.repository.FicheroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class FicheroServiceImpl implements FicheroService {
    @Autowired
    FicheroRepository ficheroRepository;

    private String path = "C:/tmp";

/* //FUNCIONA PRIMERA PARTE DEL EJERCICIO
    public Fichero guardarFichero(MultipartFile file, String categoria, String ruta) throws IOException {
        // Obtener nombre de fichero original
        String name = file.getOriginalFilename();

        // Guardar el fichero en disco
        Path filePath = Paths.get(ruta, name);
        file.transferTo(filePath);

        // Crear una instancia de FicheroEntity
        Fichero fichero = new Fichero();
        fichero.setName(name);
        fichero.setRuta(filePath.toString());
        fichero.setFechaSubida(new Date());
        fichero.setCategoria(categoria);

        // Guardar en la base de datos utilizando el repositorio
        return ficheroRepository.save(fichero);
    }

    public Fichero buscarFicheroPorId(long id) {
        return ficheroRepository.findById(id).orElse(null);
    }

    public Fichero buscarFicheroPorNombre(String name) {
        return ficheroRepository.findByName(name);
    }

*/

    ///////


    public Fichero guardarFichero(MultipartFile file, String categoria, String tipo) throws IOException {
        // Lógica para subir el fichero y guardar los metadatos en la base de datos
        if (file.isEmpty()) {
            throw new IllegalArgumentException("El archivo está vacío");
        }
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (!extension.equals(tipo)) {
            throw new IllegalArgumentException("Extensión de archivo no válida");
        }
        // Obtener nombre de fichero original
        String name = file.getOriginalFilename();

        // Guardar el fichero en disco
        Path filePath = Paths.get(path).resolve(name);
        file.transferTo(filePath);

        // Crear una instancia de FicheroEntity
        Fichero fichero = new Fichero();
        fichero.setName(name);
        fichero.setTipo(tipo);
        fichero.setRuta(filePath.toString());
        fichero.setFechaSubida(new Date());
        fichero.setCategoria(categoria);

        // Guardar en la base de datos utilizando el repositorio
        return ficheroRepository.save(fichero);
    }


    public Resource descargarFichero(Long id) throws IOException {
        Fichero fichero;
        if (id != null) {
            fichero = ficheroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Fichero no encontrado"));

        } else {
            throw new IllegalArgumentException("Debe proporcionar ID o nombre de fichero");
        }

        Path filePath = Paths.get(fichero.getRuta());

        return new FileSystemResource(filePath.toFile());
//        Resource resource = new UrlResource(filePath.toUri());
//
//        if (resource.exists()) {
//            return resource;
//        } else {
//            throw new IOException("No se puede leer el archivo: " + fichero.getName());
//        }
    }

    public ResponseEntity<String> modificarRuta(String ruta) {
        // Realiza las validaciones necesarias en la ruta
        if (ruta == null || ruta.isEmpty()) {
            return ResponseEntity.badRequest().body("La ruta no puede estar vacía.");
        }

        File directorio = new File(ruta);
        if (!directorio.exists() || !directorio.isDirectory()) {
            return ResponseEntity.badRequest().body("La ruta proporcionada no es un directorio válido.");
        }

        if (!directorio.canWrite()) {
            return ResponseEntity.badRequest().body("No tienes permisos para escribir en el directorio proporcionado.");
        }
        path = ruta;
        // Devuelve una respuesta indicando que la ruta se ha modificado con éxito
        return ResponseEntity.ok().body("Ruta modificada con éxito a: " + path);
    }

}
