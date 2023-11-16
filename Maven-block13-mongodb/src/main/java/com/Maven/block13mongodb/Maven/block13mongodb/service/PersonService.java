package com.Maven.block13mongodb.Maven.block13mongodb.service;

import com.Maven.block13mongodb.Maven.block13mongodb.domain.Persona;
import org.springframework.data.domain.Page;

public interface PersonService {


    Persona guardarPersona(Persona persona);

    Page<Persona> obtenerPersonas(int pagina, int tamañoPagina);

    Persona obtenerPersonaPorId(Long id);

    Persona actualizarPersona(Long id, Persona persona);

    void eliminarPersona(Long id);
}
