package block7crudvalidation.domain;

import block7crudvalidation.controller.dto.ProfesorOutputDto;
import block7crudvalidation.controller.dto.StudentInputDto;
import block7crudvalidation.controller.dto.StudentOutputDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="estudiantes")
public class Student {
    @Id
    @GeneratedValue
    Long idStudent;

    @OneToOne
    @JoinColumn(name = "idPerson")
    Person person;

    @NotNull
    int num_hours_week;

    String coments;

    @ManyToOne
    @JoinColumn(name = "idProfesor")
    Profesor profesor;


    @NotNull
    String branch;

    @ManyToMany
    @JoinColumn(name = "idAsignatura")
    List<Asignatura> asignaturas = new ArrayList<>();




    public Student(StudentInputDto studentInputDto) {
        this.num_hours_week = studentInputDto.getNum_hours_week();
        this.coments = studentInputDto.getComents();
        this.branch = studentInputDto.getBranch();
    }

    public StudentOutputDto studentToStudentOutputDto() {
        Long personId = (this.person != null) ? this.person.getIdPerson() : null;

        return new StudentOutputDto(

                this.idStudent,
                personId,
                this.num_hours_week,
                this.coments,
                (this.profesor != null) ? this.profesor.getIdProfesor() : null,
                this.branch
        );

    }

}

/*    id_student string [pk, increment]
    id_persona string [ref:-  persona.id_persona] -- Relación OneToOne con la tabla persona.
    num_hours_week int   [not null] -- Número de horas semanales del estudiante en formación
    coments string
    id_profesor string [ref: > profesor.id_profesor] -- Un estudiante solo puede tener un profesor.
    branch string [not null] -- Rama principal delestudiante (Front, Back, FullStack)*/