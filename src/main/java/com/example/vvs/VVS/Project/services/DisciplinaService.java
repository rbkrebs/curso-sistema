package com.example.vvs.VVS.Project.services;

import com.example.vvs.VVS.Project.models.Disciplina;


import java.util.List;

public interface DisciplinaService {

    void save(Disciplina disciplina);

    void edit(Disciplina disciplina);

    void delete(Long id);

    Disciplina findById(Long id);

    List<Disciplina> findAll();
}
