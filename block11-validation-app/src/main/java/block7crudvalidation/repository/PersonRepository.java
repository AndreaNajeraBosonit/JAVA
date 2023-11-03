package block7crudvalidation.repository;


import block7crudvalidation.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository  extends JpaRepository<Person, Long>  {
    List<Person> findByUsuarioContainingIgnoreCase(String usuario);


}
