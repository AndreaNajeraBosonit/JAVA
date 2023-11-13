package block7crudvalidation.repository;

import block7crudvalidation.domain.Person;
import block7crudvalidation.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesorRepository  extends JpaRepository<Profesor, Long> {
    Optional<Profesor> findByPerson(Person Person);

    @Override
    Profesor save(Profesor profesor);
}
