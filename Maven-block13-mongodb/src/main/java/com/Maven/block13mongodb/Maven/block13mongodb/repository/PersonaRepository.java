package com.Maven.block13mongodb.Maven.block13mongodb.repository;

import com.Maven.block13mongodb.Maven.block13mongodb.domain.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, Long> {
}
