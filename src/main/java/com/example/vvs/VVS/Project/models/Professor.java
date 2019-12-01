package com.example.vvs.VVS.Project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;



@Entity
@Data
@Table(name = "Professor")
@AllArgsConstructor
@NoArgsConstructor
public class Professor implements Serializable {

    //private static final Long serialVersionUID = 1L;
    @Id
    //@Column(name = "professor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 3)
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
