package com.example.vvs.VVS.Project.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@Table(name = "Professor")
public class Professor implements Serializable {

    //private static final Long serialVersionUID = 1L;
    @Id
    //@Column(name = "professor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private Integer cargaHoraria;
    /*@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Professor_Disciplina",
            joinColumns = { @JoinColumn(name = "professor_id") },
            inverseJoinColumns = { @JoinColumn(name = "disciplina_id") }
    )
    private List<Disciplina> disciplinas;*/

}
