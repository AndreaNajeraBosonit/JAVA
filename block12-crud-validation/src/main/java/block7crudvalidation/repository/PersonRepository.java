package block7crudvalidation.repository;


import block7crudvalidation.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository  extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
    List<Person> findByUsuarioContainingIgnoreCase(String usuario);

}
