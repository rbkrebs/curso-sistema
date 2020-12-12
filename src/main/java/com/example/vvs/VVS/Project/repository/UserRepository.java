package com.example.vvs.VVS.Project.repository;

import com.example.vvs.VVS.Project.models.Disciplina;
import com.example.vvs.VVS.Project.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
