package com.Maven.block13mongodb.Maven.block13mongodb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "personas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    private Long id;

    private String nombre;
    private int edad;

    // getters y setters
}
