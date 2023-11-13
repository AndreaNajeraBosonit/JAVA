package block7crudvalidation.domain;

import block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.controller.dto.ProfesorOutputDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idProfesor;

        @OneToOne
        @JoinColumn(name = "idPerson")
        Person person;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "profesor")
        List<Student> students;

        String coments;


        String branch;

        public Profesor(ProfesorInputDto profesorInputDto ) {
                this.coments = profesorInputDto.getComents();
                this.branch = profesorInputDto.getBranch();
                this.setStudents(students);
                this.students = new ArrayList<>(); // Inicializa la lista de estudiantes

        }
        public void addStudent(Student student) {
                if (this.students == null) {
                        this.students = new ArrayList<>();
                }
                this.students.add(student);
        }

        public Profesor(Long idProfesor, Person person) {
                this.idProfesor = idProfesor;

                // Inicializa otros parámetros
                this.person = person;
        }


        public Long getIdPerson() {
                return (person != null) ? person.getIdPerson() : null;
        }



        public ProfesorOutputDto profesorToProfesorOutputDto() {
                if (this.person != null) {
                        return new ProfesorOutputDto(
                                this.idProfesor,
                                this.person.getIdPerson(),
                                this.coments,
                                this.branch
                        );
                } else {
                        // Manejar el caso en que this.person sea null, posiblemente lanzar una excepción o devolver un valor predeterminado
                        return new ProfesorOutputDto();
                }
        }


}


/*
    id_profesor string [pk, increment]
    id_persona string [ref:- persona.id_persona] -- Relación OneToOne con la tabla persona.
    coments string
    branch string [not null] -- Materia principal que imparte. Por ejemplo: Front
*/

