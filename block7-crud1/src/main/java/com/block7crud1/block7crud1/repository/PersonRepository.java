package com.block7crud1.block7crud1.repository;

import com.block7crud1.block7crud1.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
   // Optional<Person> findByName(String nombre);

   List<Person> findByNombreContainingIgnoreCase(String name);
}
