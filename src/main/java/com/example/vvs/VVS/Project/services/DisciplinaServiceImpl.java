package com.example.vvs.VVS.Project.services;

import com.example.vvs.VVS.Project.models.Disciplina;
import com.example.vvs.VVS.Project.models.Professor;
import com.example.vvs.VVS.Project.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class DisciplinaServiceImpl implements DisciplinaService{

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public void save(Disciplina disciplina) {

        disciplinaRepository.save(disciplina);
    }

    @Override
    public void edit(Disciplina disciplina) {

        disciplinaRepository.save(disciplina);

    }

    @Override
    public void delete(Long id) {

        disciplinaRepository.deleteById(id);

    }

    @Override
    public Disciplina findById(Long id) {

        return disciplinaRepository.findById(id).get();
    }

    @Override
    public List<Disciplina> findAll() {

        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinaRepository.findAll().forEach(disciplinas :: add);
        return disciplinas;
    }
}
