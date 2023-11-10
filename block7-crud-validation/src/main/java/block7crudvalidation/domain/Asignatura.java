package block7crudvalidation.domain;

import block7crudvalidation.controller.dto.AsignaturaInputDto;
import block7crudvalidation.controller.dto.AsignaturaOutputDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAsignatura;

    @ManyToMany
    @JoinColumn(name = "idStudent")
    List<Student> student = new ArrayList<>();

    String asignatura;

    String coments;
    @NotNull
    Date initial_date;

    Date finish_date;

    public Asignatura(AsignaturaInputDto asignaturaInputDto) {
        this.asignatura = asignaturaInputDto.getAsignatura();
        this.coments = asignaturaInputDto.getComents();
        this.initial_date = asignaturaInputDto.getInitial_date();
        this.finish_date = asignaturaInputDto.getFinish_date();
    }


    public AsignaturaOutputDto asignaturaToAsignaturaOutputDto() {
        List<Long> longList = new ArrayList<>();
        this.student.forEach(student -> longList.add(student.idStudent));
        return new AsignaturaOutputDto(
            this.idAsignatura ,
            longList ,
            this.asignatura ,
            this.coments ,
            this.initial_date,
            this.finish_date
     );
    }







/*
    id_asignatura String [pk, increment]
    id_student string [ref: > student.id_student] -- Un estudiante puede tener N asignaturas
    asignatura string  -- Nombre de asignatura. Ejemplo: HTML, Angular, SpringBoot...
    coments string
    initial_date date [not null], -- Fecha en que estudiante empezó a estudiar la asignatura
    finish_date date  -- Fecha en que estudiante termina de estudiar la asignatura
*/
    }
