package com.example.vvs.VVS.Project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

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
    //Fazer os relacionamentos entre tabelas depois
    //@ManyToMany(mappedBy = "disciplinas")
   // Set<Professor> professores = new HashSet<>();

   // @ManyToMany(mappedBy = "disciplinas")
    //private List<Professor> professores;



}
