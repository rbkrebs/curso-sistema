package com.example.vvs.VVS.Project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Data
@Table(name = "Disciplina")
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina extends AbstractEntity<Long> {


    @NotNull
    @Size(min = 3)
    private String nome;
    @NotNull
    private Integer cargaHoraria;

    @ManyToMany(mappedBy = "disciplinas")
    private List<Professor> professores;

}
