package block7crudvalidation.controller.dto;

import block7crudvalidation.security.Role;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Data
public class PersonOutputDto {

    Long idPerson;
    String usuario;
    String admin;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;
    Role role;
    Long idProfesor;
    Long idStudent;

    //ProfesorOutputDto profesorOutputDto;
    public PersonOutputDto(Long idPerson, String usuario, String admin, String password, String name, String surname, String company_email, String personal_email, String city, Boolean active, Date created_date, String imagen_url, Date termination_date, Long idProfesor, Long idStudent) {

        this.idPerson = idPerson;
        this.usuario = usuario;
        this.admin=admin;
        this.password = password;

        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.personal_email = personal_email;
        this.city = city;
        this.active = active;
        this.created_date = created_date;
        this.imagen_url = imagen_url;
        this.termination_date = termination_date;
        this.idProfesor=idProfesor;
        this.idStudent=idStudent;
    }

    // En la clase PersonOutputDto


}
