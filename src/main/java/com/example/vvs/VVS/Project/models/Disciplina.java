package com.example.vvs.VVS.Project.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Disciplina")
public class Disciplina implements Serializable {

    //private static final Long serialVersionUID = 1L;
    @Id
    //@Column(name = "disciplina_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private Integer cargaHoraria;
    //Fazer os relacionamentos entre tabelas depois
    //@ManyToMany(mappedBy = "disciplinas")
   // Set<Professor> professores = new HashSet<>();

   // @ManyToMany(mappedBy = "disciplinas")
    //private List<Professor> professores;


}
