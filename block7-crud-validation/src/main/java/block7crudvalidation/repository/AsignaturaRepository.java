package block7crudvalidation.repository;

import block7crudvalidation.domain.Asignatura;
import block7crudvalidation.domain.Person;
import block7crudvalidation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AsignaturaRepository  extends JpaRepository<Asignatura, Long>  {



}

