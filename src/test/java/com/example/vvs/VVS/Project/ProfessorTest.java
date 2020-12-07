package com.example.vvs.VVS.Project;


import com.example.vvs.VVS.Project.models.Professor;
import com.example.vvs.VVS.Project.repository.ProfessorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.Assert.assertEquals;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfessorTest {
    /*

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private ProfessorRepository professorRepository;


    @Before
    public void setUp() {

        //cria algumas entidades para testes

        this.testEntityManager.persist(new Professor("prof1", 10));
        this.testEntityManager.persist(new Professor("prof2", 20));
        this.testEntityManager.persist(new Professor("prof3", 30));
        this.testEntityManager.persist(new Professor("prof4", 40));
        this.testEntityManager.persist(new Professor("prof5", 60));
        this.testEntityManager.persist(new Professor("prof6", 60));
    }

    @Test
    public void testLListaTodosProfessores(){
        // when
        List<Professor> p = (List<Professor>) professorRepository.findAll();
        // then
        assertThat(p.size()).isEqualTo(6);
    }
    @Test
    public void testCargaHorariaPorId(){
        // when
        Professor p =  professorRepository.findById(1L).get();
        // then
        assertThat(p.getCargaHoraria()).isEqualTo(10);
    }
    @Test
    public void testCargaHorariaPorNome(){
        // when
        Professor p =  professorRepository.findByNome("prof6").get(0);
        // then
        assertThat(p.getCargaHoraria()).isEqualTo(60);
    }

    @Test
    public void testListaPorCargaHoraria(){
        // when
        List<Professor> p =  professorRepository.findByCargaHoraria(60);
        // then
        assertThat(p.size()).isEqualTo(2);
    }*/

}
