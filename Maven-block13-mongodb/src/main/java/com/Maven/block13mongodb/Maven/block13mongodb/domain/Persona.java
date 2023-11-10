package com.Maven.block13mongodb.Maven.block13mongodb.domain;

import com.Maven.block13mongodb.Maven.block13mongodb.controller.dto.PersonInputDto;
import com.Maven.block13mongodb.Maven.block13mongodb.controller.dto.PersonOutputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "personas")



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    Long idPerson;

 //   @NotNull(message = "Usuario no puede se nulo ")
   // @Length(max = 10, message = "Longitud de usuario no puede ser superior a 10 caracteres")
  //  @NotEmpty
    String usuario;

    String password;

    String name;

    String surname;

  //  @Email(message = "Por favor, introduce una dirección de correo electrónico válida")
   // @NotNull
    //@NotEmpty
    String company_email;

    String personal_email;

    String city;

    Boolean active;

    Date created_date;

    String imagen_url;

    Date termination_date;




    public Persona(PersonInputDto personInputDto) {
        this.idPerson = personInputDto.getId();
        this.usuario = personInputDto.getUsuario();
        this.password = personInputDto.getPassword();
        this.name = personInputDto.getName();
        this.surname = personInputDto.getSurname();
        this.company_email = personInputDto.getCompany_email();
        this.personal_email = personInputDto.getPersonal_email();
        this.city = personInputDto.getCity();
        this.active = personInputDto.getActive();
        this.created_date = personInputDto.getCreated_date();
        this.imagen_url = personInputDto.getImagen_url();
        this.termination_date = personInputDto.getTermination_date();

    }

    public PersonOutputDto personToPersonOutputDto() {

        return new PersonOutputDto(
                this.idPerson,
                this.usuario,
                this.password,
                this.name,
                this.surname,
                this.company_email,
                this.personal_email,
                this.city,
                this.active,
                this.created_date,
                this.imagen_url,
                this.termination_date

                );





    }
}
