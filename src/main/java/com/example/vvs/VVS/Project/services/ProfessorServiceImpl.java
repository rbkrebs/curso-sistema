package com.example.vvs.VVS.Project.services;

import com.example.vvs.VVS.Project.models.Professor;
import com.example.vvs.VVS.Project.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public void save(Professor professor) {

        professorRepository.save(professor);

    }

    @Override
    public void edit(Professor professor) {

        professorRepository.save(professor);

    }

    @Override
    public void delete(Long id) {

        professorRepository.deleteById(id);
    }

    @Override
    public Professor findById(Long id) {


        return professorRepository.findById(id).get();
    }

    @Override
    public List<Professor> findAll() {

        List<Professor> professors = new ArrayList<>();
        professorRepository.findAll().forEach(professors :: add);
        return professors;
    }
}
