package block7crudvalidation.domain;

import block7crudvalidation.controller.dto.ProfesorInputDto;
import block7crudvalidation.controller.dto.ProfesorOutputDto;
import jakarta.persistence.*;
import lombok.*;

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

        public Profesor(ProfesorInputDto profesorInputDto) {
                this.coments = profesorInputDto.getComents();
                this.branch = profesorInputDto.getBranch();
                this.setStudents(students);
        }



        public ProfesorOutputDto profesorToProfesorOutputDto() {
                return new ProfesorOutputDto(
                        this.idProfesor,
                        this.person.getIdPerson(),
                        this.coments,
                        this.branch
                );

        }


/*
    id_profesor string [pk, increment]
    id_persona string [ref:- persona.id_persona] -- Relación OneToOne con la tabla persona.
    coments string
    branch string [not null] -- Materia principal que imparte. Por ejemplo: Front
*/

}
