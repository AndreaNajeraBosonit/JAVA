package block7crudvalidation.repository;


import block7crudvalidation.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import  java.util.Optional;
import java.util.List;

public interface PersonRepository  extends JpaRepository<Person, Long>  {
    List<Person> findByUsuarioContainingIgnoreCase(String usuario);

    @Query("SELECT P FROM Person P " +
            "WHERE P.username = :username")
    Optional<Person> findByUsuario(@Param("username") String username);
}
