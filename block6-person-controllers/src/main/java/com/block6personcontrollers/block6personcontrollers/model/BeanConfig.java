package com.block6personcontrollers.block6personcontrollers.model;

import com.block6personcontrollers.block6personcontrollers.model.PersonaModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
* 3) Crear 3 objetos Persona diferentes con funciones que tengan la etiqueta @Bean.  La primera función pondrá el nombre a ‘bean1’, el segundo a “bean2” y el tercero a “bean3”. Usar @Qualifiers
En un controlador con la URL /controlador/bean/{bean} dependiendo del parámetro mandado devolver cada uno de los Beans. Asi: /controlador/bean/bean1
* devolverá el objeto cuyo nombre sea bean1 y así sucesivamente.
*/
@Configuration
public class BeanConfig {

    @Bean(name = "bean1")
    public PersonaModel bean1() {
        PersonaModel personaModel = new PersonaModel();
        personaModel.setNombre("bean1");
        personaModel.setEdad(29);
        personaModel.setPoblacion("Logroño");
        return personaModel;
    }

    @Bean(name = "bean2")
    public PersonaModel bean2() {
        PersonaModel personaModel = new PersonaModel();
        personaModel.setNombre("bean2");
        return personaModel;
    }

    @Bean(name = "bean3")
    public PersonaModel bean3() {
        PersonaModel personaModel = new PersonaModel();
        personaModel.setNombre("bean3");
        return personaModel;
    }

}
