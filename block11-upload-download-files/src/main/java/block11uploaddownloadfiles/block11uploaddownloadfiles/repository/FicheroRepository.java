package block11uploaddownloadfiles.block11uploaddownloadfiles.repository;

import block11uploaddownloadfiles.block11uploaddownloadfiles.domain.Fichero;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


@Repository

public interface FicheroRepository extends JpaRepository<Fichero, Long > {

/* //FUNCIONA PRIMERA PARTE DEL EJERCICIO
    Fichero findByName(String name);
*/

}



