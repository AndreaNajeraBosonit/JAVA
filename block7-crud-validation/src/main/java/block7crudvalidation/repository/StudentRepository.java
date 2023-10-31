package block7crudvalidation.repository;

import block7crudvalidation.domain.Asignatura;
import block7crudvalidation.domain.Person;
import block7crudvalidation.domain.Profesor;
import block7crudvalidation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudentRepository  extends JpaRepository<Student, Long>  {
    Optional<Student> findByPerson(Person Person);
    List<Student> findByAsignaturas(Asignatura asignatura);


}