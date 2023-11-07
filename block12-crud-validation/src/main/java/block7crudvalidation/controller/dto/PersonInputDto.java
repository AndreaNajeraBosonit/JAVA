package block7crudvalidation.controller.dto;

import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor


public class PersonInputDto {
    Long idPerson;
    String usuario;
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
 boolean esProfesor;
     boolean esStudent;


    public PersonInputDto(Long idPerson, String usuario, String password, String name, String surname, String company_email, String personal_email, String city, Boolean active, Date created_date, String imagen_url, Date termination_date) {
        this.idPerson = idPerson;
        this.usuario = usuario;
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
    }

    public boolean isEsProfesor() {
        return esProfesor;
    }

    public boolean isEsStudent() {
        return esStudent;
    }
    public Long getId() {
        return idPerson;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCompany_email() {
        return company_email;
    }

    public String getPersonal_email() {
        return personal_email;
    }

    public String getCity() {
        return city;
    }

    public Boolean getActive() {
        return active;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public Date getTermination_date() {
        return termination_date;
    }

    public void setId(Long idPerson) {
        this.idPerson = idPerson;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public void setPersonal_email(String personal_email) {
        this.personal_email = personal_email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public void setTermination_date(Date termination_date) {
        this.termination_date = termination_date;
    }


}
