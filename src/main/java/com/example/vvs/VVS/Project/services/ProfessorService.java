package com.example.vvs.VVS.Project.services;

import com.example.vvs.VVS.Project.models.Professor;

import java.util.List;

public interface ProfessorService {

    void save(Professor professor);

    void edit(Professor professor);

    void delete (Long id);

    Professor findById(Long id);

    List<Professor> findAll();
}
