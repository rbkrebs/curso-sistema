package com.example.vvs.VVS.Project.repository;

import com.example.vvs.VVS.Project.models.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProfessorRepository  extends CrudRepository<Professor, Long> {

}
