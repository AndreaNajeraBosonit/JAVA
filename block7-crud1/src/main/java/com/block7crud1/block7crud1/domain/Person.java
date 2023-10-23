package com.block7crud1.block7crud1.domain;

import com.block7crud1.block7crud1.controller.dto.PersonInputDto;
import com.block7crud1.block7crud1.controller.dto.PersonOutputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Person {

        @Id
        @GeneratedValue
        int id;
        String nombre;
        String edad;
        String poblacion;

        public Person(PersonInputDto personInputDto) {
                this.id = personInputDto.getId();
                this.nombre = personInputDto.getNombre();
                this.edad = personInputDto.getEdad();
                this.poblacion = personInputDto.getPoblacion();
        }

        public PersonOutputDto personToPersonOutputDto() {
                return new PersonOutputDto(
                        this.id,
                        this.nombre,
                        this.edad,
                        this.poblacion
                );

        }
}
