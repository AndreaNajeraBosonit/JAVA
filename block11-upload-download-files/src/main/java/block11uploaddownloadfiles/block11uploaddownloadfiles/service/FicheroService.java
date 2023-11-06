package block11uploaddownloadfiles.block11uploaddownloadfiles.service;


import block11uploaddownloadfiles.block11uploaddownloadfiles.domain.Fichero;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FicheroService {



    Resource descargarFichero(Long id) throws IOException;

    Fichero guardarFichero(MultipartFile file, String categoria, String tipo) throws IOException;

    ResponseEntity<String> modificarRuta(String ruta);



/* //FUNCIONA PRIMERA PARTE DEL EJERCICO
    Fichero guardarFichero(MultipartFile file, String name, String categoria) throws IOException;

    Fichero buscarFicheroPorId(long id);

    Fichero buscarFicheroPorNombre(String name);

*/
}
