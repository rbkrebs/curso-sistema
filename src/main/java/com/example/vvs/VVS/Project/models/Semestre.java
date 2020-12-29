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
@Table(name = "Semestre")
@AllArgsConstructor
@NoArgsConstructor
public class Semestre extends AbstractEntity<Long> {


    @NotNull
    @Size(min = 3)
    private String text_id;








}
