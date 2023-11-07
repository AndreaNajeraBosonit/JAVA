package block7crudvalidation.domain;

import block7crudvalidation.controller.dto.PersonInputDto;
import block7crudvalidation.controller.dto.PersonOutputDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue
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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "person")
    Profesor profesor;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "person")
    Student student;



    public Person(PersonInputDto personInputDto) {
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
                this.termination_date,
                this.profesor==null?null: profesor.getIdProfesor(),
                this.student==null?null:student.getIdStudent()
                );

        //



    }
}


