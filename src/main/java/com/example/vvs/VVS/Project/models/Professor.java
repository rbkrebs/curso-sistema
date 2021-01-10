package com.example.vvs.VVS.Project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Entity
@Data
@Table(name = "Professor")
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends AbstractEntity<Long>{


    @NotNull
    @Size(min = 3)
    private String nome;
    @NotNull
    private Integer cargaHoraria;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataAdmissao;

    @ManyToMany
    @JoinTable(
            name = "disciplina_professor",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
    private List<Disciplina> disciplinas;


}
