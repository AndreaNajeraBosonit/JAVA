package com.Maven.block13mongodb.Maven.block13mongodb.service;

import com.Maven.block13mongodb.Maven.block13mongodb.domain.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonService {

    private final MongoTemplate mongoTemplate;

    public PersonaServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        mongoTemplate.save(persona);
        return persona;
    }
    @Override
    public Page<Persona> obtenerPersonas(int pagina, int tamañoPagina) {
        Query query = new Query();
        long totalPersonas = mongoTemplate.count(query, Persona.class);

        query.with(PageRequest.of(pagina, tamañoPagina));
        List<Persona> personas = mongoTemplate.find(query, Persona.class);

        return new PageImpl<>(personas, PageRequest.of(pagina, tamañoPagina), totalPersonas);
    }

    @Override
    public Persona obtenerPersonaPorId(Long id) {
        // Implementa la lógica para obtener una persona por su ID
        return mongoTemplate.findById(id, Persona.class);
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update()
                .set("nombre", persona.getNombre()) // Reemplaza "nombre" con el nombre del campo que deseas actualizar
                .set("edad", persona.getEdad()); // Reemplaza "edad" con el nombre del campo que deseas actualizar

        // Puedes agregar más campos según sea necesario

        mongoTemplate.updateFirst(query, update, Persona.class);

        return persona; // Puedes ajustar el retorno según tus necesidades
    }

    @Override
    public void eliminarPersona(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Persona.class);
    }
}
